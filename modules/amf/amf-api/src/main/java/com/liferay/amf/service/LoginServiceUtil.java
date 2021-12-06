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

import com.liferay.amf.model.Login;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for Login. This utility wraps
 * <code>com.liferay.amf.service.impl.LoginServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Bruno Queiroz
 * @see LoginService
 * @generated
 */
public class LoginServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.service.impl.LoginServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Login addLogin(
			long groupId, String emailAddress, String password)
		throws PortalException {

		return getService().addLogin(groupId, emailAddress, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static LoginService getService() {
		return _service;
	}

	private static volatile LoginService _service;

}