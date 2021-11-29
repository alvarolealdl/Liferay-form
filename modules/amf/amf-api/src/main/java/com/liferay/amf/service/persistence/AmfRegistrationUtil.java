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

import com.liferay.amf.model.AmfRegistration;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the amf registration service. This utility wraps <code>com.liferay.amf.service.persistence.impl.AmfRegistrationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationPersistence
 * @generated
 */
public class AmfRegistrationUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AmfRegistration amfRegistration) {
		getPersistence().clearCache(amfRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AmfRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AmfRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AmfRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AmfRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AmfRegistration> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AmfRegistration update(AmfRegistration amfRegistration) {
		return getPersistence().update(amfRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AmfRegistration update(
		AmfRegistration amfRegistration, ServiceContext serviceContext) {

		return getPersistence().update(amfRegistration, serviceContext);
	}

	/**
	 * Caches the amf registration in the entity cache if it is enabled.
	 *
	 * @param amfRegistration the amf registration
	 */
	public static void cacheResult(AmfRegistration amfRegistration) {
		getPersistence().cacheResult(amfRegistration);
	}

	/**
	 * Caches the amf registrations in the entity cache if it is enabled.
	 *
	 * @param amfRegistrations the amf registrations
	 */
	public static void cacheResult(List<AmfRegistration> amfRegistrations) {
		getPersistence().cacheResult(amfRegistrations);
	}

	/**
	 * Creates a new amf registration with the primary key. Does not add the amf registration to the database.
	 *
	 * @param amfRegistrationId the primary key for the new amf registration
	 * @return the new amf registration
	 */
	public static AmfRegistration create(long amfRegistrationId) {
		return getPersistence().create(amfRegistrationId);
	}

	/**
	 * Removes the amf registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfRegistrationId the primary key of the amf registration
	 * @return the amf registration that was removed
	 * @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	 */
	public static AmfRegistration remove(long amfRegistrationId)
		throws com.liferay.amf.exception.NoSuchAmfRegistrationException {

		return getPersistence().remove(amfRegistrationId);
	}

	public static AmfRegistration updateImpl(AmfRegistration amfRegistration) {
		return getPersistence().updateImpl(amfRegistration);
	}

	/**
	 * Returns the amf registration with the primary key or throws a <code>NoSuchAmfRegistrationException</code> if it could not be found.
	 *
	 * @param amfRegistrationId the primary key of the amf registration
	 * @return the amf registration
	 * @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	 */
	public static AmfRegistration findByPrimaryKey(long amfRegistrationId)
		throws com.liferay.amf.exception.NoSuchAmfRegistrationException {

		return getPersistence().findByPrimaryKey(amfRegistrationId);
	}

	/**
	 * Returns the amf registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfRegistrationId the primary key of the amf registration
	 * @return the amf registration, or <code>null</code> if a amf registration with the primary key could not be found
	 */
	public static AmfRegistration fetchByPrimaryKey(long amfRegistrationId) {
		return getPersistence().fetchByPrimaryKey(amfRegistrationId);
	}

	/**
	 * Returns all the amf registrations.
	 *
	 * @return the amf registrations
	 */
	public static List<AmfRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the amf registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf registrations
	 * @param end the upper bound of the range of amf registrations (not inclusive)
	 * @return the range of amf registrations
	 */
	public static List<AmfRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the amf registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf registrations
	 * @param end the upper bound of the range of amf registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf registrations
	 */
	public static List<AmfRegistration> findAll(
		int start, int end,
		OrderByComparator<AmfRegistration> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf registrations
	 * @param end the upper bound of the range of amf registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amf registrations
	 */
	public static List<AmfRegistration> findAll(
		int start, int end,
		OrderByComparator<AmfRegistration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the amf registrations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of amf registrations.
	 *
	 * @return the number of amf registrations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AmfRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AmfRegistrationPersistence, AmfRegistrationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AmfRegistrationPersistence.class);

		ServiceTracker<AmfRegistrationPersistence, AmfRegistrationPersistence>
			serviceTracker =
				new ServiceTracker
					<AmfRegistrationPersistence, AmfRegistrationPersistence>(
						bundle.getBundleContext(),
						AmfRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}