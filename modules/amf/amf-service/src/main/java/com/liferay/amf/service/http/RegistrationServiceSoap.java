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

package com.liferay.amf.service.http;

import com.liferay.amf.service.RegistrationServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>RegistrationServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.amf.model.RegistrationSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.amf.model.Registration</code>, that is translated to a
 * <code>com.liferay.amf.model.RegistrationSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Bruno Queiroz
 * @see RegistrationServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class RegistrationServiceSoap {

	public static com.liferay.amf.model.RegistrationSoap addRegistration(
			long groupId, String userName, String firstName, String lastName,
			String emailAddress, boolean gender, java.util.Date birthday,
			String password, String homePhone, String mobilePhone,
			String address1, String address2, String city, String state,
			long zipCode, String securityAnswer)
		throws RemoteException {

		try {
			com.liferay.amf.model.Registration returnValue =
				RegistrationServiceUtil.addRegistration(
					groupId, userName, firstName, lastName, emailAddress,
					gender, birthday, password, homePhone, mobilePhone,
					address1, address2, city, state, zipCode, securityAnswer);

			return com.liferay.amf.model.RegistrationSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.amf.model.RegistrationSoap updateRegistration(
			long registrationId, String firstName, String lastName,
			String emailAddress, String address1)
		throws RemoteException {

		try {
			com.liferay.amf.model.Registration returnValue =
				RegistrationServiceUtil.updateRegistration(
					registrationId, firstName, lastName, emailAddress,
					address1);

			return com.liferay.amf.model.RegistrationSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.amf.model.RegistrationSoap deleteRegistration(
			long registrationId)
		throws RemoteException {

		try {
			com.liferay.amf.model.Registration returnValue =
				RegistrationServiceUtil.deleteRegistration(registrationId);

			return com.liferay.amf.model.RegistrationSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.amf.model.RegistrationSoap[]
			getAllRegistrationById(long registrationId)
		throws RemoteException {

		try {
			java.util.List<com.liferay.amf.model.Registration> returnValue =
				RegistrationServiceUtil.getAllRegistrationById(registrationId);

			return com.liferay.amf.model.RegistrationSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.amf.model.RegistrationSoap
			getEmailAddressByUserId(long userId)
		throws RemoteException {

		try {
			com.liferay.amf.model.Registration returnValue =
				RegistrationServiceUtil.getEmailAddressByUserId(userId);

			return com.liferay.amf.model.RegistrationSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.amf.model.RegistrationSoap getById(long userId)
		throws RemoteException {

		try {
			com.liferay.amf.model.Registration returnValue =
				RegistrationServiceUtil.getById(userId);

			return com.liferay.amf.model.RegistrationSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		RegistrationServiceSoap.class);

}