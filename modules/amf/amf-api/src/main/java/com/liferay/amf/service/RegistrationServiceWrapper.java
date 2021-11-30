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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistrationService}.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationService
 * @generated
 */
public class RegistrationServiceWrapper
	implements RegistrationService, ServiceWrapper<RegistrationService> {

	public RegistrationServiceWrapper(RegistrationService registrationService) {
		_registrationService = registrationService;
	}

	@Override
	public com.liferay.amf.model.Registration addRegistration(
			String userName, String firstName, String lastName,
			String emailAddress, String gender, java.util.Date birthday,
			String password, String homePhone, String mobilePhone,
			String address1, String address2, String city, String state,
			long zipCode, String securityAnswer)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationService.addRegistration(
			userName, firstName, lastName, emailAddress, gender, birthday,
			password, homePhone, mobilePhone, address1, address2, city, state,
			zipCode, securityAnswer);
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
	public RegistrationService getWrappedService() {
		return _registrationService;
	}

	@Override
	public void setWrappedService(RegistrationService registrationService) {
		_registrationService = registrationService;
	}

	private RegistrationService _registrationService;

}