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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>RegistrationServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Bruno Queiroz
 * @see RegistrationServiceSoap
 * @generated
 */
public class RegistrationServiceHttp {

	public static com.liferay.amf.model.Registration addRegistration(
			HttpPrincipal httpPrincipal, long groupId, String userName,
			String firstName, String lastName, String emailAddress,
			String gender, java.util.Date birthday, String password,
			String homePhone, String mobilePhone, String address1,
			String address2, String city, String state, long zipCode,
			String securityAnswer)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationServiceUtil.class, "addRegistration",
				_addRegistrationParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, userName, firstName, lastName, emailAddress,
				gender, birthday, password, homePhone, mobilePhone, address1,
				address2, city, state, zipCode, securityAnswer);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.amf.model.Registration)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.amf.model.Registration updateRegistration(
			HttpPrincipal httpPrincipal, long registrationId, String firstName,
			String lastName, String emailAddress, String address1)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationServiceUtil.class, "updateRegistration",
				_updateRegistrationParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, registrationId, firstName, lastName, emailAddress,
				address1);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.amf.model.Registration)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.amf.model.Registration deleteRegistration(
			HttpPrincipal httpPrincipal, long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationServiceUtil.class, "deleteRegistration",
				_deleteRegistrationParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, registrationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.amf.model.Registration)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.amf.model.Registration>
		getAllRegistrationById(
			HttpPrincipal httpPrincipal, long registrationId) {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationServiceUtil.class, "getAllRegistrationById",
				_getAllRegistrationByIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, registrationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.amf.model.Registration>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.amf.model.Registration getEmailAddressByUserId(
		HttpPrincipal httpPrincipal, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationServiceUtil.class, "getEmailAddressByUserId",
				_getEmailAddressByUserIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.amf.model.Registration)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.amf.model.Registration getById(
			HttpPrincipal httpPrincipal, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationServiceUtil.class, "getById",
				_getByIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.amf.model.Registration)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		RegistrationServiceHttp.class);

	private static final Class<?>[] _addRegistrationParameterTypes0 =
		new Class[] {
			long.class, String.class, String.class, String.class, String.class,
			String.class, java.util.Date.class, String.class, String.class,
			String.class, String.class, String.class, String.class,
			String.class, long.class, String.class
		};
	private static final Class<?>[] _updateRegistrationParameterTypes1 =
		new Class[] {
			long.class, String.class, String.class, String.class, String.class
		};
	private static final Class<?>[] _deleteRegistrationParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getAllRegistrationByIdParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _getEmailAddressByUserIdParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _getByIdParameterTypes5 = new Class[] {
		long.class
	};

}