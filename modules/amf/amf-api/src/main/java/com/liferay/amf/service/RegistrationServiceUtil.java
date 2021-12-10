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

import java.util.List;

/**
 * Provides the remote service utility for Registration. This utility wraps
 * <code>com.liferay.amf.service.impl.RegistrationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Bruno Queiroz
 * @see RegistrationService
 * @generated
 */
public class RegistrationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.service.impl.RegistrationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Registration addRegistration(
			long groupId, String userName, String firstName, String lastName,
			String emailAddress, String gender, java.util.Date birthday,
			String password, String homePhone, String mobilePhone,
			String address1, String address2, String city, String state,
			long zipCode, String securityAnswer)
		throws PortalException {

		return getService().addRegistration(
			groupId, userName, firstName, lastName, emailAddress, gender,
			birthday, password, homePhone, mobilePhone, address1, address2,
			city, state, zipCode, securityAnswer);
	}

	public static Registration deleteRegistration(long registrationId)
		throws PortalException {

		return getService().deleteRegistration(registrationId);
	}

	public static List<Registration> getAllRegistrationById(long registrationId)
		throws PortalException {

		return getService().getAllRegistrationById(registrationId);
	}

	public static Registration getById(long userId) throws PortalException {
		return getService().getById(userId);
	}

	public static Registration getEmailAddressByUserId(long userId) {
		return getService().getEmailAddressByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Registration updateRegistration(
			long registrationId, String firstName, String lastName,
			String emailAddress, String address1)
		throws PortalException {

		return getService().updateRegistration(
			registrationId, firstName, lastName, emailAddress, address1);
	}

	public static RegistrationService getService() {
		return _service;
	}

	private static volatile RegistrationService _service;

}