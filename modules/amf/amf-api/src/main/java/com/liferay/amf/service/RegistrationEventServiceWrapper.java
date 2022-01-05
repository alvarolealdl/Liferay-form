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
 * Provides a wrapper for {@link RegistrationEventService}.
 *
 * @author Bruno Queiroz
 * @see RegistrationEventService
 * @generated
 */
public class RegistrationEventServiceWrapper
	implements RegistrationEventService,
			   ServiceWrapper<RegistrationEventService> {

	public RegistrationEventServiceWrapper(
		RegistrationEventService registrationEventService) {

		_registrationEventService = registrationEventService;
	}

	@Override
	public com.liferay.amf.model.RegistrationEvent addEvent(
			long groupId, long companyId, String eventType, String ipAddress,
			String userName, java.util.Date eventDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationEventService.addEvent(
			groupId, companyId, eventType, ipAddress, userName, eventDate);
	}

	@Override
	public com.liferay.amf.model.RegistrationEvent addEvent(
			com.liferay.amf.model.RegistrationEvent registrationEvent)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationEventService.addEvent(registrationEvent);
	}

	@Override
	public java.util.List<com.liferay.amf.model.RegistrationEvent>
		getAllEvents() {

		return _registrationEventService.getAllEvents();
	}

	@Override
	public com.liferay.amf.model.RegistrationEvent getEvent(
		long registrationEventId) {

		return _registrationEventService.getEvent(registrationEventId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _registrationEventService.getOSGiServiceIdentifier();
	}

	@Override
	public RegistrationEventService getWrappedService() {
		return _registrationEventService;
	}

	@Override
	public void setWrappedService(
		RegistrationEventService registrationEventService) {

		_registrationEventService = registrationEventService;
	}

	private RegistrationEventService _registrationEventService;

}