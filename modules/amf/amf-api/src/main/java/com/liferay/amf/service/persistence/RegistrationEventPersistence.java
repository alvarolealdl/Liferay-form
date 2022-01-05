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

package com.liferay.amf.service.persistence;

import com.liferay.amf.exception.NoSuchEventException;
import com.liferay.amf.model.RegistrationEvent;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the registration event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Queiroz
 * @see RegistrationEventUtil
 * @generated
 */
@ProviderType
public interface RegistrationEventPersistence
	extends BasePersistence<RegistrationEvent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegistrationEventUtil} to access the registration event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the registration event in the entity cache if it is enabled.
	 *
	 * @param registrationEvent the registration event
	 */
	public void cacheResult(RegistrationEvent registrationEvent);

	/**
	 * Caches the registration events in the entity cache if it is enabled.
	 *
	 * @param registrationEvents the registration events
	 */
	public void cacheResult(
		java.util.List<RegistrationEvent> registrationEvents);

	/**
	 * Creates a new registration event with the primary key. Does not add the registration event to the database.
	 *
	 * @param registrationEventId the primary key for the new registration event
	 * @return the new registration event
	 */
	public RegistrationEvent create(long registrationEventId);

	/**
	 * Removes the registration event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registrationEventId the primary key of the registration event
	 * @return the registration event that was removed
	 * @throws NoSuchEventException if a registration event with the primary key could not be found
	 */
	public RegistrationEvent remove(long registrationEventId)
		throws NoSuchEventException;

	public RegistrationEvent updateImpl(RegistrationEvent registrationEvent);

	/**
	 * Returns the registration event with the primary key or throws a <code>NoSuchEventException</code> if it could not be found.
	 *
	 * @param registrationEventId the primary key of the registration event
	 * @return the registration event
	 * @throws NoSuchEventException if a registration event with the primary key could not be found
	 */
	public RegistrationEvent findByPrimaryKey(long registrationEventId)
		throws NoSuchEventException;

	/**
	 * Returns the registration event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registrationEventId the primary key of the registration event
	 * @return the registration event, or <code>null</code> if a registration event with the primary key could not be found
	 */
	public RegistrationEvent fetchByPrimaryKey(long registrationEventId);

	/**
	 * Returns all the registration events.
	 *
	 * @return the registration events
	 */
	public java.util.List<RegistrationEvent> findAll();

	/**
	 * Returns a range of all the registration events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration events
	 * @param end the upper bound of the range of registration events (not inclusive)
	 * @return the range of registration events
	 */
	public java.util.List<RegistrationEvent> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the registration events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration events
	 * @param end the upper bound of the range of registration events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of registration events
	 */
	public java.util.List<RegistrationEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationEvent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the registration events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration events
	 * @param end the upper bound of the range of registration events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of registration events
	 */
	public java.util.List<RegistrationEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the registration events from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of registration events.
	 *
	 * @return the number of registration events
	 */
	public int countAll();

}