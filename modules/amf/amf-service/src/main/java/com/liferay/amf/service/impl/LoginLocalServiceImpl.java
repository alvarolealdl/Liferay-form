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

import com.liferay.amf.exception.LoginValidationExceptionException;
import com.liferay.amf.model.Login;
import com.liferay.amf.service.base.LoginLocalServiceBaseImpl;
import com.liferay.amf.service.persistence.LoginPersistence;
import com.liferay.amf.validator.LoginValidator;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.poller.PollerException;
import com.liferay.portal.kernel.security.pwd.PasswordEncryptorUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the login local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.service.LoginLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno Queiroz
 * @see LoginLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.amf.model.Login",
	service = AopService.class
)
public class LoginLocalServiceImpl extends LoginLocalServiceBaseImpl {

	public Login addLogin(long groupId, String emailAddress, String password) throws PortalException {

		_loginValidator.validate(emailAddress);

		long loginId = counterLocalService.increment(Login.class.getName());
		Login login = _loginPersistence.create(loginId);

		login.setGroupId(groupId);
		login.setEmailAddress(emailAddress);
		login.setPassword(PasswordEncryptorUtil.encrypt(password));

		return _loginPersistence.update(login);

	}


	@Reference
	private LoginValidator _loginValidator;

	@Reference
	private ServiceContext _serviceContext;

	@Reference
	private LoginPersistence _loginPersistence;

}