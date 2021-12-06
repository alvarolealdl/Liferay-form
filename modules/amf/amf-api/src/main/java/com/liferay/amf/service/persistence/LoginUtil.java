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

import com.liferay.amf.model.Login;
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
 * The persistence utility for the login service. This utility wraps <code>com.liferay.amf.service.persistence.impl.LoginPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Queiroz
 * @see LoginPersistence
 * @generated
 */
public class LoginUtil {

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
	public static void clearCache(Login login) {
		getPersistence().clearCache(login);
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
	public static Map<Serializable, Login> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Login> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Login> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Login> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Login> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Login update(Login login) {
		return getPersistence().update(login);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Login update(Login login, ServiceContext serviceContext) {
		return getPersistence().update(login, serviceContext);
	}

	/**
	 * Caches the login in the entity cache if it is enabled.
	 *
	 * @param login the login
	 */
	public static void cacheResult(Login login) {
		getPersistence().cacheResult(login);
	}

	/**
	 * Caches the logins in the entity cache if it is enabled.
	 *
	 * @param logins the logins
	 */
	public static void cacheResult(List<Login> logins) {
		getPersistence().cacheResult(logins);
	}

	/**
	 * Creates a new login with the primary key. Does not add the login to the database.
	 *
	 * @param loginId the primary key for the new login
	 * @return the new login
	 */
	public static Login create(long loginId) {
		return getPersistence().create(loginId);
	}

	/**
	 * Removes the login with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loginId the primary key of the login
	 * @return the login that was removed
	 * @throws NoSuchLoginException if a login with the primary key could not be found
	 */
	public static Login remove(long loginId)
		throws com.liferay.amf.exception.NoSuchLoginException {

		return getPersistence().remove(loginId);
	}

	public static Login updateImpl(Login login) {
		return getPersistence().updateImpl(login);
	}

	/**
	 * Returns the login with the primary key or throws a <code>NoSuchLoginException</code> if it could not be found.
	 *
	 * @param loginId the primary key of the login
	 * @return the login
	 * @throws NoSuchLoginException if a login with the primary key could not be found
	 */
	public static Login findByPrimaryKey(long loginId)
		throws com.liferay.amf.exception.NoSuchLoginException {

		return getPersistence().findByPrimaryKey(loginId);
	}

	/**
	 * Returns the login with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loginId the primary key of the login
	 * @return the login, or <code>null</code> if a login with the primary key could not be found
	 */
	public static Login fetchByPrimaryKey(long loginId) {
		return getPersistence().fetchByPrimaryKey(loginId);
	}

	/**
	 * Returns all the logins.
	 *
	 * @return the logins
	 */
	public static List<Login> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the logins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoginModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of logins
	 * @param end the upper bound of the range of logins (not inclusive)
	 * @return the range of logins
	 */
	public static List<Login> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the logins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoginModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of logins
	 * @param end the upper bound of the range of logins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of logins
	 */
	public static List<Login> findAll(
		int start, int end, OrderByComparator<Login> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the logins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoginModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of logins
	 * @param end the upper bound of the range of logins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of logins
	 */
	public static List<Login> findAll(
		int start, int end, OrderByComparator<Login> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the logins from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of logins.
	 *
	 * @return the number of logins
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LoginPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoginPersistence, LoginPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LoginPersistence.class);

		ServiceTracker<LoginPersistence, LoginPersistence> serviceTracker =
			new ServiceTracker<LoginPersistence, LoginPersistence>(
				bundle.getBundleContext(), LoginPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}