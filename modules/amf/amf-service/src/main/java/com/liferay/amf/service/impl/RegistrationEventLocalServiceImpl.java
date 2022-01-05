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
import com.liferay.amf.service.base.RegistrationEventLocalServiceBaseImpl;
import com.liferay.amf.service.persistence.RegistrationEventPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the registration event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.service.RegistrationEventLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno Queiroz
 * @see RegistrationEventLocalServiceBaseImpl
 */
@Component(
		immediate = true,
		property = "model.class.name=com.liferay.amf.model.RegistrationEvent",
		service = AopService.class
)
public class RegistrationEventLocalServiceImpl
	extends RegistrationEventLocalServiceBaseImpl {

	public RegistrationEvent addEvent(RegistrationEvent registrationEvent) throws PortalException {

		return _registrationEventPersistence.update(registrationEvent);

	}

	public RegistrationEvent addEvent(long groupId, long companyId, String eventType,
									  String ipAddress, String userName, Date eventDate ) throws PortalException{

		long userId = counterLocalService.increment(User.class.getName());
		long registrationEventId = counterLocalService.increment(RegistrationEvent.class.getName());
		RegistrationEvent registrationEvent = _registrationEventPersistence.create(registrationEventId);
		registrationEvent.setGroupId(groupId);
		registrationEvent.setCompanyId(companyId);
		registrationEvent.setEventType(eventType);
		registrationEvent.setIpAddress(ipAddress);
		registrationEvent.setUserName(userName);
		registrationEvent.setCreateDate(eventDate);
		registrationEvent.setUserId(userId);

		return _registrationEventPersistence.update(registrationEvent);

	}

	//Finders Methods

	public RegistrationEvent getEvent(long registrationEventId){
		return _registrationEventPersistence.fetchByPrimaryKey(registrationEventId);
	}

	public List<RegistrationEvent> getAllEvents(){
		return _registrationEventPersistence.findAll();
	}

	@Reference
	private RegistrationEventPersistence _registrationEventPersistence;
}