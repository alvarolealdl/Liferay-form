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

import com.liferay.amf.model.RegistrationEvent;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for RegistrationEvent. This utility wraps
 * <code>com.liferay.amf.service.impl.RegistrationEventServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Bruno Queiroz
 * @see RegistrationEventService
 * @generated
 */
public class RegistrationEventServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.service.impl.RegistrationEventServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static RegistrationEvent addEvent(
			long groupId, long companyId, String eventType, String ipAddress,
			String userName, java.util.Date eventDate)
		throws PortalException {

		return getService().addEvent(
			groupId, companyId, eventType, ipAddress, userName, eventDate);
	}

	public static RegistrationEvent addEvent(
			RegistrationEvent registrationEvent)
		throws PortalException {

		return getService().addEvent(registrationEvent);
	}

	public static List<RegistrationEvent> getAllEvents() {
		return getService().getAllEvents();
	}

	public static RegistrationEvent getEvent(long registrationEventId) {
		return getService().getEvent(registrationEventId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static RegistrationEventService getService() {
		return _service;
	}

	private static volatile RegistrationEventService _service;

}