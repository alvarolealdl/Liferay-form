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

import com.liferay.amf.model.RegistrationEvent;
import com.liferay.amf.service.RegistrationEventLocalService;
import com.liferay.amf.service.base.RegistrationEventServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the registration event remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.service.RegistrationEventService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Bruno Queiroz
 * @see RegistrationEventServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=registration",
		"json.web.service.context.path=RegistrationEvent"
	},
	service = AopService.class
)
public class RegistrationEventServiceImpl
	extends RegistrationEventServiceBaseImpl {

	public RegistrationEvent addEvent(RegistrationEvent registrationEvent) throws PortalException {
		return _registrationEventLocalService.addEvent(registrationEvent);
	}

	public RegistrationEvent addEvent(long groupId, long companyId, String eventType,
											String ipAddress, String userName, Date eventDate) throws PortalException{
		return _registrationEventLocalService.addEvent(groupId, companyId, eventType, ipAddress, userName, eventDate);
	}

	public RegistrationEvent getEvent(long registrationEventId){

		return _registrationEventLocalService.getEvent(registrationEventId);

	}

	public List<RegistrationEvent> getAllEvents(){
		return _registrationEventLocalService.getAllEvents();
	}

	@Reference
	private RegistrationEventLocalService _registrationEventLocalService;
}