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

import com.liferay.amf.exception.NoSuchRegistrationException;
import com.liferay.amf.model.Registration;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Queiroz
 * @see RegistrationUtil
 * @generated
 */
@ProviderType
public interface RegistrationPersistence extends BasePersistence<Registration> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegistrationUtil} to access the registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the registrations where amfRegistrationId = &#63;.
	 *
	 * @param amfRegistrationId the amf registration ID
	 * @return the matching registrations
	 */
	public java.util.List<Registration> findByRegistrationId(
		long amfRegistrationId);

	/**
	 * Returns a range of all the registrations where amfRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param amfRegistrationId the amf registration ID
	 * @param start the lower bound of the range of registrations
	 * @param end the upper bound of the range of registrations (not inclusive)
	 * @return the range of matching registrations
	 */
	public java.util.List<Registration> findByRegistrationId(
		long amfRegistrationId, int start, int end);

	/**
	 * Returns an ordered range of all the registrations where amfRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param amfRegistrationId the amf registration ID
	 * @param start the lower bound of the range of registrations
	 * @param end the upper bound of the range of registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registrations
	 */
	public java.util.List<Registration> findByRegistrationId(
		long amfRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the registrations where amfRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param amfRegistrationId the amf registration ID
	 * @param start the lower bound of the range of registrations
	 * @param end the upper bound of the range of registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registrations
	 */
	public java.util.List<Registration> findByRegistrationId(
		long amfRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration in the ordered set where amfRegistrationId = &#63;.
	 *
	 * @param amfRegistrationId the amf registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration
	 * @throws NoSuchRegistrationException if a matching registration could not be found
	 */
	public Registration findByRegistrationId_First(
			long amfRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator<Registration>
				orderByComparator)
		throws NoSuchRegistrationException;

	/**
	 * Returns the first registration in the ordered set where amfRegistrationId = &#63;.
	 *
	 * @param amfRegistrationId the amf registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration, or <code>null</code> if a matching registration could not be found
	 */
	public Registration fetchByRegistrationId_First(
		long amfRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator<Registration>
			orderByComparator);

	/**
	 * Returns the last registration in the ordered set where amfRegistrationId = &#63;.
	 *
	 * @param amfRegistrationId the amf registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration
	 * @throws NoSuchRegistrationException if a matching registration could not be found
	 */
	public Registration findByRegistrationId_Last(
			long amfRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator<Registration>
				orderByComparator)
		throws NoSuchRegistrationException;

	/**
	 * Returns the last registration in the ordered set where amfRegistrationId = &#63;.
	 *
	 * @param amfRegistrationId the amf registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration, or <code>null</code> if a matching registration could not be found
	 */
	public Registration fetchByRegistrationId_Last(
		long amfRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator<Registration>
			orderByComparator);

	/**
	 * Removes all the registrations where amfRegistrationId = &#63; from the database.
	 *
	 * @param amfRegistrationId the amf registration ID
	 */
	public void removeByRegistrationId(long amfRegistrationId);

	/**
	 * Returns the number of registrations where amfRegistrationId = &#63;.
	 *
	 * @param amfRegistrationId the amf registration ID
	 * @return the number of matching registrations
	 */
	public int countByRegistrationId(long amfRegistrationId);

	/**
	 * Returns the registration where userId = &#63; or throws a <code>NoSuchRegistrationException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching registration
	 * @throws NoSuchRegistrationException if a matching registration could not be found
	 */
	public Registration findByEmailAddress(long userId)
		throws NoSuchRegistrationException;

	/**
	 * Returns the registration where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching registration, or <code>null</code> if a matching registration could not be found
	 */
	public Registration fetchByEmailAddress(long userId);

	/**
	 * Returns the registration where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching registration, or <code>null</code> if a matching registration could not be found
	 */
	public Registration fetchByEmailAddress(
		long userId, boolean useFinderCache);

	/**
	 * Removes the registration where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the registration that was removed
	 */
	public Registration removeByEmailAddress(long userId)
		throws NoSuchRegistrationException;

	/**
	 * Returns the number of registrations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching registrations
	 */
	public int countByEmailAddress(long userId);

	/**
	 * Returns the registration where userId = &#63; or throws a <code>NoSuchRegistrationException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching registration
	 * @throws NoSuchRegistrationException if a matching registration could not be found
	 */
	public Registration findByRegistrationById(long userId)
		throws NoSuchRegistrationException;

	/**
	 * Returns the registration where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching registration, or <code>null</code> if a matching registration could not be found
	 */
	public Registration fetchByRegistrationById(long userId);

	/**
	 * Returns the registration where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching registration, or <code>null</code> if a matching registration could not be found
	 */
	public Registration fetchByRegistrationById(
		long userId, boolean useFinderCache);

	/**
	 * Removes the registration where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the registration that was removed
	 */
	public Registration removeByRegistrationById(long userId)
		throws NoSuchRegistrationException;

	/**
	 * Returns the number of registrations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching registrations
	 */
	public int countByRegistrationById(long userId);

	/**
	 * Caches the registration in the entity cache if it is enabled.
	 *
	 * @param registration the registration
	 */
	public void cacheResult(Registration registration);

	/**
	 * Caches the registrations in the entity cache if it is enabled.
	 *
	 * @param registrations the registrations
	 */
	public void cacheResult(java.util.List<Registration> registrations);

	/**
	 * Creates a new registration with the primary key. Does not add the registration to the database.
	 *
	 * @param amfRegistrationId the primary key for the new registration
	 * @return the new registration
	 */
	public Registration create(long amfRegistrationId);

	/**
	 * Removes the registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfRegistrationId the primary key of the registration
	 * @return the registration that was removed
	 * @throws NoSuchRegistrationException if a registration with the primary key could not be found
	 */
	public Registration remove(long amfRegistrationId)
		throws NoSuchRegistrationException;

	public Registration updateImpl(Registration registration);

	/**
	 * Returns the registration with the primary key or throws a <code>NoSuchRegistrationException</code> if it could not be found.
	 *
	 * @param amfRegistrationId the primary key of the registration
	 * @return the registration
	 * @throws NoSuchRegistrationException if a registration with the primary key could not be found
	 */
	public Registration findByPrimaryKey(long amfRegistrationId)
		throws NoSuchRegistrationException;

	/**
	 * Returns the registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfRegistrationId the primary key of the registration
	 * @return the registration, or <code>null</code> if a registration with the primary key could not be found
	 */
	public Registration fetchByPrimaryKey(long amfRegistrationId);

	/**
	 * Returns all the registrations.
	 *
	 * @return the registrations
	 */
	public java.util.List<Registration> findAll();

	/**
	 * Returns a range of all the registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registrations
	 * @param end the upper bound of the range of registrations (not inclusive)
	 * @return the range of registrations
	 */
	public java.util.List<Registration> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registrations
	 * @param end the upper bound of the range of registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of registrations
	 */
	public java.util.List<Registration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registrations
	 * @param end the upper bound of the range of registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of registrations
	 */
	public java.util.List<Registration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the registrations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of registrations.
	 *
	 * @return the number of registrations
	 */
	public int countAll();

}