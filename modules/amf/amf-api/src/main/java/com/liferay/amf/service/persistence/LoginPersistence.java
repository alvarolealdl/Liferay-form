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

import com.liferay.amf.exception.NoSuchLoginException;
import com.liferay.amf.model.Login;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the login service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Queiroz
 * @see LoginUtil
 * @generated
 */
@ProviderType
public interface LoginPersistence extends BasePersistence<Login> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoginUtil} to access the login persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the login in the entity cache if it is enabled.
	 *
	 * @param login the login
	 */
	public void cacheResult(Login login);

	/**
	 * Caches the logins in the entity cache if it is enabled.
	 *
	 * @param logins the logins
	 */
	public void cacheResult(java.util.List<Login> logins);

	/**
	 * Creates a new login with the primary key. Does not add the login to the database.
	 *
	 * @param loginId the primary key for the new login
	 * @return the new login
	 */
	public Login create(long loginId);

	/**
	 * Removes the login with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loginId the primary key of the login
	 * @return the login that was removed
	 * @throws NoSuchLoginException if a login with the primary key could not be found
	 */
	public Login remove(long loginId) throws NoSuchLoginException;

	public Login updateImpl(Login login);

	/**
	 * Returns the login with the primary key or throws a <code>NoSuchLoginException</code> if it could not be found.
	 *
	 * @param loginId the primary key of the login
	 * @return the login
	 * @throws NoSuchLoginException if a login with the primary key could not be found
	 */
	public Login findByPrimaryKey(long loginId) throws NoSuchLoginException;

	/**
	 * Returns the login with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loginId the primary key of the login
	 * @return the login, or <code>null</code> if a login with the primary key could not be found
	 */
	public Login fetchByPrimaryKey(long loginId);

	/**
	 * Returns all the logins.
	 *
	 * @return the logins
	 */
	public java.util.List<Login> findAll();

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
	public java.util.List<Login> findAll(int start, int end);

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
	public java.util.List<Login> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Login>
			orderByComparator);

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
	public java.util.List<Login> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Login>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the logins from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of logins.
	 *
	 * @return the number of logins
	 */
	public int countAll();

}