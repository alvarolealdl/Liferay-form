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

package com.liferay.amf.service.persistence.impl;

import com.liferay.amf.exception.NoSuchAmfRegistrationException;
import com.liferay.amf.model.AmfRegistration;
import com.liferay.amf.model.AmfRegistrationTable;
import com.liferay.amf.model.impl.AmfRegistrationImpl;
import com.liferay.amf.model.impl.AmfRegistrationModelImpl;
import com.liferay.amf.service.persistence.AmfRegistrationPersistence;
import com.liferay.amf.service.persistence.impl.constants.AmfRegistrationPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the amf registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {AmfRegistrationPersistence.class, BasePersistence.class})
public class AmfRegistrationPersistenceImpl
	extends BasePersistenceImpl<AmfRegistration>
	implements AmfRegistrationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AmfRegistrationUtil</code> to access the amf registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AmfRegistrationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AmfRegistrationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");
		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AmfRegistration.class);

		setModelImplClass(AmfRegistrationImpl.class);
		setModelPKClass(long.class);

		setTable(AmfRegistrationTable.INSTANCE);
	}

	/**
	 * Caches the amf registration in the entity cache if it is enabled.
	 *
	 * @param amfRegistration the amf registration
	 */
	@Override
	public void cacheResult(AmfRegistration amfRegistration) {
		entityCache.putResult(
			AmfRegistrationImpl.class, amfRegistration.getPrimaryKey(),
			amfRegistration);
	}

	/**
	 * Caches the amf registrations in the entity cache if it is enabled.
	 *
	 * @param amfRegistrations the amf registrations
	 */
	@Override
	public void cacheResult(List<AmfRegistration> amfRegistrations) {
		for (AmfRegistration amfRegistration : amfRegistrations) {
			if (entityCache.getResult(
					AmfRegistrationImpl.class,
					amfRegistration.getPrimaryKey()) == null) {

				cacheResult(amfRegistration);
			}
		}
	}

	/**
	 * Clears the cache for all amf registrations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AmfRegistrationImpl.class);

		finderCache.clearCache(AmfRegistrationImpl.class);
	}

	/**
	 * Clears the cache for the amf registration.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AmfRegistration amfRegistration) {
		entityCache.removeResult(AmfRegistrationImpl.class, amfRegistration);
	}

	@Override
	public void clearCache(List<AmfRegistration> amfRegistrations) {
		for (AmfRegistration amfRegistration : amfRegistrations) {
			entityCache.removeResult(
				AmfRegistrationImpl.class, amfRegistration);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AmfRegistrationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AmfRegistrationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new amf registration with the primary key. Does not add the amf registration to the database.
	 *
	 * @param amfRegistrationId the primary key for the new amf registration
	 * @return the new amf registration
	 */
	@Override
	public AmfRegistration create(long amfRegistrationId) {
		AmfRegistration amfRegistration = new AmfRegistrationImpl();

		amfRegistration.setNew(true);
		amfRegistration.setPrimaryKey(amfRegistrationId);

		amfRegistration.setCompanyId(CompanyThreadLocal.getCompanyId());

		return amfRegistration;
	}

	/**
	 * Removes the amf registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfRegistrationId the primary key of the amf registration
	 * @return the amf registration that was removed
	 * @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	 */
	@Override
	public AmfRegistration remove(long amfRegistrationId)
		throws NoSuchAmfRegistrationException {

		return remove((Serializable)amfRegistrationId);
	}

	/**
	 * Removes the amf registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amf registration
	 * @return the amf registration that was removed
	 * @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	 */
	@Override
	public AmfRegistration remove(Serializable primaryKey)
		throws NoSuchAmfRegistrationException {

		Session session = null;

		try {
			session = openSession();

			AmfRegistration amfRegistration = (AmfRegistration)session.get(
				AmfRegistrationImpl.class, primaryKey);

			if (amfRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAmfRegistrationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(amfRegistration);
		}
		catch (NoSuchAmfRegistrationException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AmfRegistration removeImpl(AmfRegistration amfRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amfRegistration)) {
				amfRegistration = (AmfRegistration)session.get(
					AmfRegistrationImpl.class,
					amfRegistration.getPrimaryKeyObj());
			}

			if (amfRegistration != null) {
				session.delete(amfRegistration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (amfRegistration != null) {
			clearCache(amfRegistration);
		}

		return amfRegistration;
	}

	@Override
	public AmfRegistration updateImpl(AmfRegistration amfRegistration) {
		boolean isNew = amfRegistration.isNew();

		if (!(amfRegistration instanceof AmfRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(amfRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					amfRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in amfRegistration proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AmfRegistration implementation " +
					amfRegistration.getClass());
		}

		AmfRegistrationModelImpl amfRegistrationModelImpl =
			(AmfRegistrationModelImpl)amfRegistration;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (amfRegistration.getCreateDate() == null)) {
			if (serviceContext == null) {
				amfRegistration.setCreateDate(date);
			}
			else {
				amfRegistration.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!amfRegistrationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				amfRegistration.setModifiedDate(date);
			}
			else {
				amfRegistration.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(amfRegistration);
			}
			else {
				amfRegistration = (AmfRegistration)session.merge(
					amfRegistration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AmfRegistrationImpl.class, amfRegistration, false, true);

		if (isNew) {
			amfRegistration.setNew(false);
		}

		amfRegistration.resetOriginalValues();

		return amfRegistration;
	}

	/**
	 * Returns the amf registration with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf registration
	 * @return the amf registration
	 * @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	 */
	@Override
	public AmfRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAmfRegistrationException {

		AmfRegistration amfRegistration = fetchByPrimaryKey(primaryKey);

		if (amfRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAmfRegistrationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return amfRegistration;
	}

	/**
	 * Returns the amf registration with the primary key or throws a <code>NoSuchAmfRegistrationException</code> if it could not be found.
	 *
	 * @param amfRegistrationId the primary key of the amf registration
	 * @return the amf registration
	 * @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	 */
	@Override
	public AmfRegistration findByPrimaryKey(long amfRegistrationId)
		throws NoSuchAmfRegistrationException {

		return findByPrimaryKey((Serializable)amfRegistrationId);
	}

	/**
	 * Returns the amf registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfRegistrationId the primary key of the amf registration
	 * @return the amf registration, or <code>null</code> if a amf registration with the primary key could not be found
	 */
	@Override
	public AmfRegistration fetchByPrimaryKey(long amfRegistrationId) {
		return fetchByPrimaryKey((Serializable)amfRegistrationId);
	}

	/**
	 * Returns all the amf registrations.
	 *
	 * @return the amf registrations
	 */
	@Override
	public List<AmfRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AmfRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AmfRegistration> findAll(
		int start, int end,
		OrderByComparator<AmfRegistration> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AmfRegistration> findAll(
		int start, int end,
		OrderByComparator<AmfRegistration> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AmfRegistration> list = null;

		if (useFinderCache) {
			list = (List<AmfRegistration>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AMFREGISTRATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AMFREGISTRATION;

				sql = sql.concat(AmfRegistrationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AmfRegistration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the amf registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AmfRegistration amfRegistration : findAll()) {
			remove(amfRegistration);
		}
	}

	/**
	 * Returns the number of amf registrations.
	 *
	 * @return the number of amf registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AMFREGISTRATION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "amfRegistrationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMFREGISTRATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AmfRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amf registration persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AmfRegistrationModelArgumentsResolver(),
			new HashMapDictionary<>());

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AmfRegistrationImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	@Override
	@Reference(
		target = AmfRegistrationPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AmfRegistrationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AmfRegistrationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AMFREGISTRATION =
		"SELECT amfRegistration FROM AmfRegistration amfRegistration";

	private static final String _SQL_COUNT_AMFREGISTRATION =
		"SELECT COUNT(amfRegistration) FROM AmfRegistration amfRegistration";

	private static final String _ORDER_BY_ENTITY_ALIAS = "amfRegistration.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AmfRegistration exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AmfRegistrationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"password", "state"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class AmfRegistrationModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			AmfRegistrationModelImpl amfRegistrationModelImpl =
				(AmfRegistrationModelImpl)baseModel;

			long columnBitmask = amfRegistrationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					amfRegistrationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						amfRegistrationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					amfRegistrationModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return AmfRegistrationImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return AmfRegistrationTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			AmfRegistrationModelImpl amfRegistrationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						amfRegistrationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = amfRegistrationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}