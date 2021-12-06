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

import com.liferay.amf.internal.security.permission.resource.LoginModelResourcePermission;
import com.liferay.amf.model.Login;
import com.liferay.amf.service.LoginLocalService;
import com.liferay.amf.service.base.LoginServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the login remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.service.LoginService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Bruno Queiroz
 * @see LoginServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=registration",
		"json.web.service.context.path=Login"
	},
	service = AopService.class
)
public class LoginServiceImpl extends LoginServiceBaseImpl {

		public Login addLogin(long groupId,String emailAddress, String password) throws  PortalException {

			_loginModelResourcePermission.check(getPermissionChecker(), _serviceContext.getScopeGroupId(),
					ActionKeys.ACCESS);

			return  _loginLocalService.addLogin(groupId, emailAddress, password);
		}

		@Reference
		private LoginLocalService _loginLocalService;

		@Reference
		private  LoginModelResourcePermission _loginModelResourcePermission;

		@Reference
		private ServiceContext _serviceContext;

}