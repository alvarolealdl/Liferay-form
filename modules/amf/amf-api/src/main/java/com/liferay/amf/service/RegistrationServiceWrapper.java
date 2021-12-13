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

package com.liferay.amf.service;

import com.liferay.amf.model.Registration;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceWrapper;

import java.util.Date;

/**
 * Provides a wrapper for {@link RegistrationService}.
 *
 * @author Bruno Queiroz
 * @see RegistrationService
 * @generated
 */
public class RegistrationServiceWrapper
	implements RegistrationService, ServiceWrapper<RegistrationService> {

	public RegistrationServiceWrapper(RegistrationService registrationService) {
		_registrationService = registrationService;
	}


	@Override
	public Registration addRegistration(long groupId, String userName, String firstName, String lastName,
										String emailAddress, boolean gender, Date birthday, String password,
										String homePhone, String mobilePhone, String address1, String address2,
										String city, String state, long zipCode, String securityAnswer)
			throws PortalException {
		return null;
	}

	@Override
	public com.liferay.amf.model.Registration deleteRegistration(
			long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationService.deleteRegistration(registrationId);
	}

	@Override
	public java.util.List<com.liferay.amf.model.Registration>
		getAllRegistrationById(long registrationId) {

		return _registrationService.getAllRegistrationById(registrationId);
	}

	@Override
	public com.liferay.amf.model.Registration getById(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationService.getById(userId);
	}

	@Override
	public com.liferay.amf.model.Registration getEmailAddressByUserId(
		long userId) {

		return _registrationService.getEmailAddressByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _registrationService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.amf.model.Registration updateRegistration(
			long registrationId, String firstName, String lastName,
			String emailAddress, String address1)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationService.updateRegistration(
			registrationId, firstName, lastName, emailAddress, address1);
	}

	@Override
	public RegistrationService getWrappedService() {
		return _registrationService;
	}

	@Override
	public void setWrappedService(RegistrationService registrationService) {
		_registrationService = registrationService;
	}

	private RegistrationService _registrationService;

}