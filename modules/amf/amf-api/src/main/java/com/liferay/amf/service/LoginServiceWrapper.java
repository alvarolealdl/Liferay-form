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
 * Provides a wrapper for {@link LoginService}.
 *
 * @author Bruno Queiroz
 * @see LoginService
 * @generated
 */
public class LoginServiceWrapper
	implements LoginService, ServiceWrapper<LoginService> {

	public LoginServiceWrapper(LoginService loginService) {
		_loginService = loginService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _loginService.getOSGiServiceIdentifier();
	}

	@Override
	public LoginService getWrappedService() {
		return _loginService;
	}

	@Override
	public void setWrappedService(LoginService loginService) {
		_loginService = loginService;
	}

	private LoginService _loginService;

}