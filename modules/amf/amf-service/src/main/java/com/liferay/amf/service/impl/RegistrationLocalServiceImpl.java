/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.amf.service.impl;

import com.liferay.amf.exception.NoSuchRegistrationException;
import com.liferay.amf.service.base.RegistrationLocalServiceBaseImpl;
import com.liferay.amf.service.persistence.RegistrationPersistence;
import com.liferay.amf.validator.RegistrationValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.amf.model.Registration;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.pwd.PasswordEncryptorUtil;
import com.liferay.portal.kernel.service.GroupLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.service.RegistrationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.amf.model.Registration",
	service = AopService.class
)
public class RegistrationLocalServiceImpl
	extends RegistrationLocalServiceBaseImpl {


	public Registration addRegistration( long groupId, String userName, String firstName,
										String lastName, String emailAddress, boolean gender, Date birthday,
										String password, String homePhone, String mobilePhone, String address1,
										String address2, String city, String state, long zipCode, String securityAnswer)
	throws PortalException {

		_registrationValidator.validate(userName, firstName, lastName, emailAddress);

		long userId = _serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		user.setScreenName("");
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailAddress(emailAddress);
		userLocalService.addUser(user);

		long amfRegistrationId = counterLocalService.increment(Registration.class.getName());

		Registration registration = _registrationPersistence.create(amfRegistrationId);
		registration.setGroupId(groupId);
		registration.setCompanyId(user.getCompanyId());
		registration.setUserId(userId);
		registration.setCreateDate(new Date());
		registration.setUserName(userName);
		registration.setFirstName(firstName);
		registration.setLastName(lastName);
		registration.setEmailAddress(emailAddress);
		registration.isMale();
		registration.setBirthday(birthday);
		registration.setPassword(PasswordEncryptorUtil.encrypt(password));
		registration.setHomePhone(homePhone);
		registration.setMobilePhone(mobilePhone);
		registration.setAddress1(address1);
		registration.setAddress2(address2);
		registration.setCity(city);
		registration.setState(state);
		registration.setZipCode(zipCode);
		registration.setSecurityAnswer(securityAnswer);

		return  _registrationPersistence.update(registration);
	}

	public Registration updateRegistration( long registrationId, String firstName, String lastName, String emailAddress,
											String address1) throws PortalException{

		_registrationValidator.validate(null, firstName, lastName, emailAddress);

			Registration registration = getRegistration(registrationId);
			registration.setModifiedDate(new Date());
			registration.setFirstName(firstName);
			registration.setLastName(lastName);
			registration.setEmailAddress(emailAddress);
			registration.setAddress1(address1);

			registration = super.updateRegistration(registration);
			return registration;

	}

	public Registration deleteRegistration(long registrationId) throws PortalException{

		return super.deleteRegistration(registrationId);
	}

	//Finders Methods
	public List<Registration> getAllRegistrationById(long registrationId)  {
		 return _registrationPersistence.findByRegistrationId(registrationId);

	}

	public Registration getEmailAddressByUserId(long userId){
		return _registrationPersistence.fetchByEmailAddress(userId);
	}

	public Registration getById(long userId) throws NoSuchRegistrationException{
		return _registrationPersistence.findByRegistrationById(userId);
	}


	@Reference
	private RegistrationPersistence _registrationPersistence;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private ServiceContext _serviceContext;

	@Reference
	private RegistrationValidator _registrationValidator;
}
