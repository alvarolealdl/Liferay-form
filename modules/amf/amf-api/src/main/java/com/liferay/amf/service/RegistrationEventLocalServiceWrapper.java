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
 * Provides a wrapper for {@link RegistrationEventLocalService}.
 *
 * @author Bruno Queiroz
 * @see RegistrationEventLocalService
 * @generated
 */
public class RegistrationEventLocalServiceWrapper
	implements RegistrationEventLocalService,
			   ServiceWrapper<RegistrationEventLocalService> {

	public RegistrationEventLocalServiceWrapper(
		RegistrationEventLocalService registrationEventLocalService) {

		_registrationEventLocalService = registrationEventLocalService;
	}

	/**
	 * Adds the registration event to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegistrationEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param registrationEvent the registration event
	 * @return the registration event that was added
	 */
	@Override
	public com.liferay.amf.model.RegistrationEvent addRegistrationEvent(
		com.liferay.amf.model.RegistrationEvent registrationEvent) {

		return _registrationEventLocalService.addRegistrationEvent(
			registrationEvent);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationEventLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new registration event with the primary key. Does not add the registration event to the database.
	 *
	 * @param registrationEventId the primary key for the new registration event
	 * @return the new registration event
	 */
	@Override
	public com.liferay.amf.model.RegistrationEvent createRegistrationEvent(
		long registrationEventId) {

		return _registrationEventLocalService.createRegistrationEvent(
			registrationEventId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationEventLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the registration event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegistrationEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param registrationEventId the primary key of the registration event
	 * @return the registration event that was removed
	 * @throws PortalException if a registration event with the primary key could not be found
	 */
	@Override
	public com.liferay.amf.model.RegistrationEvent deleteRegistrationEvent(
			long registrationEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationEventLocalService.deleteRegistrationEvent(
			registrationEventId);
	}

	/**
	 * Deletes the registration event from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegistrationEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param registrationEvent the registration event
	 * @return the registration event that was removed
	 */
	@Override
	public com.liferay.amf.model.RegistrationEvent deleteRegistrationEvent(
		com.liferay.amf.model.RegistrationEvent registrationEvent) {

		return _registrationEventLocalService.deleteRegistrationEvent(
			registrationEvent);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _registrationEventLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _registrationEventLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _registrationEventLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _registrationEventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.model.impl.RegistrationEventModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _registrationEventLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.model.impl.RegistrationEventModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _registrationEventLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _registrationEventLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _registrationEventLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.amf.model.RegistrationEvent fetchRegistrationEvent(
		long registrationEventId) {

		return _registrationEventLocalService.fetchRegistrationEvent(
			registrationEventId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _registrationEventLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _registrationEventLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _registrationEventLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationEventLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the registration event with the primary key.
	 *
	 * @param registrationEventId the primary key of the registration event
	 * @return the registration event
	 * @throws PortalException if a registration event with the primary key could not be found
	 */
	@Override
	public com.liferay.amf.model.RegistrationEvent getRegistrationEvent(
			long registrationEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationEventLocalService.getRegistrationEvent(
			registrationEventId);
	}

	/**
	 * Returns a range of all the registration events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.model.impl.RegistrationEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration events
	 * @param end the upper bound of the range of registration events (not inclusive)
	 * @return the range of registration events
	 */
	@Override
	public java.util.List<com.liferay.amf.model.RegistrationEvent>
		getRegistrationEvents(int start, int end) {

		return _registrationEventLocalService.getRegistrationEvents(start, end);
	}

	/**
	 * Returns the number of registration events.
	 *
	 * @return the number of registration events
	 */
	@Override
	public int getRegistrationEventsCount() {
		return _registrationEventLocalService.getRegistrationEventsCount();
	}

	/**
	 * Updates the registration event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegistrationEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param registrationEvent the registration event
	 * @return the registration event that was updated
	 */
	@Override
	public com.liferay.amf.model.RegistrationEvent updateRegistrationEvent(
		com.liferay.amf.model.RegistrationEvent registrationEvent) {

		return _registrationEventLocalService.updateRegistrationEvent(
			registrationEvent);
	}

	@Override
	public RegistrationEventLocalService getWrappedService() {
		return _registrationEventLocalService;
	}

	@Override
	public void setWrappedService(
		RegistrationEventLocalService registrationEventLocalService) {

		_registrationEventLocalService = registrationEventLocalService;
	}

	private RegistrationEventLocalService _registrationEventLocalService;

}