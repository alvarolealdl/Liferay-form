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


import com.liferay.amf.model.Registration;
import com.liferay.amf.service.RegistrationLocalService;
import com.liferay.amf.service.base.RegistrationServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the registration remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.service.RegistrationService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=amfRegistration",
		"json.web.service.context.path=Registration"
	},
	service = AopService.class
)
public class RegistrationServiceImpl extends RegistrationServiceBaseImpl {


	public Registration updateRegistration(long registrationId, String firstName, String lastName, String emailAddress,
										   String address1) throws PortalException {

		return _registrationLocalService.updateRegistration(registrationId, firstName, lastName, emailAddress,
				address1);
	}

	@Override
	public Registration addRegistration(long groupId, String userName, String firstName, String lastName, String emailAddress, boolean gender, Date birthday, String password, String homePhone, String mobilePhone, String address1, String address2, String city, String state, long zipCode, String securityAnswer) throws PortalException {
		return _registrationLocalService.addRegistration(groupId, userName, firstName, lastName, emailAddress, gender,
				birthday, password, homePhone, mobilePhone, address1, address2, city, state, zipCode, securityAnswer);
	}

	public Registration deleteRegistration(long registrationId) throws PortalException {



		Registration registration = _registrationLocalService.getRegistration(registrationId);
		return _registrationLocalService.deleteRegistration(registration);
	}

	public List<Registration> getAllRegistrationById(long registrationId) {

		return _registrationLocalService.getAllRegistrationById(registrationId);

	}

	public Registration getEmailAddressByUserId(long userId) {

		return _registrationLocalService.getEmailAddressByUserId(userId);
	}

	public Registration getById(long userId) throws PortalException {

		Registration registration = _registrationLocalService.getById(userId);

		return registration;
	}


	@Reference
	private RegistrationLocalService _registrationLocalService;



}