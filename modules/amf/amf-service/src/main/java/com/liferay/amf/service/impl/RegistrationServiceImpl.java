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

//import com.liferay.amf.internal.security.permission.resource.RegistrationModelResourcePermission;
import com.liferay.amf.exception.NoSuchRegistrationException;
import com.liferay.amf.service.base.RegistrationServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.amf.model.Registration;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

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


	public Registration addRegistration( long groupId, String userName, String firstName,
										   String lastName, String emailAddress, String gender, Date birthday,
										   String password, String homePhone, String mobilePhone, String address1,
										   String address2, String city, String state, long zipCode, String securityAnswer)
			throws PortalException {

		_portletResourcePermission.check(getPermissionChecker(), _serviceContext.getScopeGroupId(),
				ActionKeys.ADD_ENTRY);

		return _registrationLocalServiceImpl.addRegistration(groupId, userName, firstName, lastName, emailAddress, gender,
				birthday, password, homePhone, mobilePhone, address1, address2, city, state, zipCode, securityAnswer);
	}

	public Registration updateRegistration( long registrationId, String firstName, String lastName, String emailAddress,
											String address1) throws PortalException{

			return _registrationLocalServiceImpl.updateRegistration(registrationId, firstName, lastName, emailAddress,
					address1);
	}

	public Registration deleteRegistration(long registrationId) throws PortalException{

		_registrationModelResourcePermission.check(getPermissionChecker(), registrationId,
				ActionKeys.DELETE);

		Registration registration = _registrationLocalServiceImpl.getRegistration(registrationId);
		return _registrationLocalServiceImpl.deleteRegistration(registration);
	}

	public List<Registration> getAllRegistrationById(long registrationId) throws PortalException{

		return _registrationLocalServiceImpl.getAllRegistrationById(registrationId);

	}

	public Registration getEmailAddressByUserId(long userId){

		return _registrationLocalServiceImpl.getEmailAddressByUserId(userId);
	}

	public Registration getById(long userId) throws PortalException {

		Registration registration = _registrationLocalServiceImpl.getById(userId);
		_registrationModelResourcePermission.check(getPermissionChecker(), registration, ActionKeys.VIEW);

		return registration;
	}




	@Reference
	private RegistrationLocalServiceImpl _registrationLocalServiceImpl;

	@Reference
	private ServiceContext _serviceContext;

	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY,
			target = "(model.class.name=com.liferay.amf.model.Registration)"
	)
	private volatile ModelResourcePermission<Registration> _registrationModelResourcePermission;

	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY,
			target = "(resource.name= com_liferay_amf_web_RegistrationPortlet)"
	)
	private PortletResourcePermission _portletResourcePermission;
}