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

import com.liferay.amf.service.base.RegistrationLocalServiceBaseImpl;
import com.liferay.amf.service.persistence.RegistrationPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.amf.model.Registration;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

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


	public Registration addRegistration(long amfReistrationId, long groupId, long companyId, long userId,
										   Date createDate, Date modifieDate, String userName, String firstName,
										   String lastName, String emailAddress, String gender, Date birthday,
										   String password, String homePhone, String mobilePhone, String address1,
										   String address2, String city, String state, long zipCode, String securityAnswer)
	throws PortalException {

		Registration registration = _registrationPersistence.create(amfReistrationId);
		registration.setGroupId(groupId);
		registration.setCompanyId(companyId);
		registration.setUserId(userId);
		registration.setCreateDate(createDate);
		registration.setModifiedDate(modifieDate);
		registration.setUserName(userName);
		registration.setFirstName(firstName);
		registration.setLastName(lastName);
		registration.setEmailAddress(emailAddress);
		registration.setEmailAddress(gender);
		registration.setBirthday(birthday);
		registration.setPassword(password);
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


	@Reference
	private RegistrationPersistence _registrationPersistence;
}
