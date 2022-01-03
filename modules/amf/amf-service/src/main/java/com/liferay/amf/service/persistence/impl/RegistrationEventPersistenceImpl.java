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

import com.liferay.amf.exception.NoSuchEventException;
import com.liferay.amf.model.RegistrationEvent;
import com.liferay.amf.model.RegistrationEventTable;
import com.liferay.amf.model.impl.RegistrationEventImpl;
import com.liferay.amf.model.impl.RegistrationEventModelImpl;
import com.liferay.amf.service.persistence.RegistrationEventPersistence;
import com.liferay.amf.service.persistence.impl.constants.RegistrationPersistenceConstants;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
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
 * The persistence implementation for the registration event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Queiroz
 * @generated
 */
@Component(
	service = {RegistrationEventPersistence.class, BasePersistence.class}
)
public class RegistrationEventPersistenceImpl
	extends BasePersistenceImpl<RegistrationEvent>
	implements RegistrationEventPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RegistrationEventUtil</code> to access the registration event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RegistrationEventImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RegistrationEventPersistenceImpl() {
		setModelClass(RegistrationEvent.class);

		setModelImplClass(RegistrationEventImpl.class);
		setModelPKClass(long.class);

		setTable(RegistrationEventTable.INSTANCE);
	}

	/**
	 * Caches the registration event in the entity cache if it is enabled.
	 *
	 * @param registrationEvent the registration event
	 */
	@Override
	public void cacheResult(RegistrationEvent registrationEvent) {
		entityCache.putResult(
			RegistrationEventImpl.class, registrationEvent.getPrimaryKey(),
			registrationEvent);
	}

	/**
	 * Caches the registration events in the entity cache if it is enabled.
	 *
	 * @param registrationEvents the registration events
	 */
	@Override
	public void cacheResult(List<RegistrationEvent> registrationEvents) {
		for (RegistrationEvent registrationEvent : registrationEvents) {
			if (entityCache.getResult(
					RegistrationEventImpl.class,
					registrationEvent.getPrimaryKey()) == null) {

				cacheResult(registrationEvent);
			}
		}
	}

	/**
	 * Clears the cache for all registration events.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RegistrationEventImpl.class);

		finderCache.clearCache(RegistrationEventImpl.class);
	}

	/**
	 * Clears the cache for the registration event.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RegistrationEvent registrationEvent) {
		entityCache.removeResult(
			RegistrationEventImpl.class, registrationEvent);
	}

	@Override
	public void clearCache(List<RegistrationEvent> registrationEvents) {
		for (RegistrationEvent registrationEvent : registrationEvents) {
			entityCache.removeResult(
				RegistrationEventImpl.class, registrationEvent);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RegistrationEventImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RegistrationEventImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new registration event with the primary key. Does not add the registration event to the database.
	 *
	 * @param registrationEventId the primary key for the new registration event
	 * @return the new registration event
	 */
	@Override
	public RegistrationEvent create(long registrationEventId) {
		RegistrationEvent registrationEvent = new RegistrationEventImpl();

		registrationEvent.setNew(true);
		registrationEvent.setPrimaryKey(registrationEventId);

		registrationEvent.setCompanyId(CompanyThreadLocal.getCompanyId());

		return registrationEvent;
	}

	/**
	 * Removes the registration event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registrationEventId the primary key of the registration event
	 * @return the registration event that was removed
	 * @throws NoSuchEventException if a registration event with the primary key could not be found
	 */
	@Override
	public RegistrationEvent remove(long registrationEventId)
		throws NoSuchEventException {

		return remove((Serializable)registrationEventId);
	}

	/**
	 * Removes the registration event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the registration event
	 * @return the registration event that was removed
	 * @throws NoSuchEventException if a registration event with the primary key could not be found
	 */
	@Override
	public RegistrationEvent remove(Serializable primaryKey)
		throws NoSuchEventException {

		Session session = null;

		try {
			session = openSession();

			RegistrationEvent registrationEvent =
				(RegistrationEvent)session.get(
					RegistrationEventImpl.class, primaryKey);

			if (registrationEvent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(registrationEvent);
		}
		catch (NoSuchEventException noSuchEntityException) {
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
	protected RegistrationEvent removeImpl(
		RegistrationEvent registrationEvent) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(registrationEvent)) {
				registrationEvent = (RegistrationEvent)session.get(
					RegistrationEventImpl.class,
					registrationEvent.getPrimaryKeyObj());
			}

			if (registrationEvent != null) {
				session.delete(registrationEvent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (registrationEvent != null) {
			clearCache(registrationEvent);
		}

		return registrationEvent;
	}

	@Override
	public RegistrationEvent updateImpl(RegistrationEvent registrationEvent) {
		boolean isNew = registrationEvent.isNew();

		if (!(registrationEvent instanceof RegistrationEventModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(registrationEvent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					registrationEvent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in registrationEvent proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RegistrationEvent implementation " +
					registrationEvent.getClass());
		}

		RegistrationEventModelImpl registrationEventModelImpl =
			(RegistrationEventModelImpl)registrationEvent;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (registrationEvent.getCreateDate() == null)) {
			if (serviceContext == null) {
				registrationEvent.setCreateDate(date);
			}
			else {
				registrationEvent.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!registrationEventModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				registrationEvent.setModifiedDate(date);
			}
			else {
				registrationEvent.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(registrationEvent);
			}
			else {
				registrationEvent = (RegistrationEvent)session.merge(
					registrationEvent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RegistrationEventImpl.class, registrationEvent, false, true);

		if (isNew) {
			registrationEvent.setNew(false);
		}

		registrationEvent.resetOriginalValues();

		return registrationEvent;
	}

	/**
	 * Returns the registration event with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the registration event
	 * @return the registration event
	 * @throws NoSuchEventException if a registration event with the primary key could not be found
	 */
	@Override
	public RegistrationEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventException {

		RegistrationEvent registrationEvent = fetchByPrimaryKey(primaryKey);

		if (registrationEvent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return registrationEvent;
	}

	/**
	 * Returns the registration event with the primary key or throws a <code>NoSuchEventException</code> if it could not be found.
	 *
	 * @param registrationEventId the primary key of the registration event
	 * @return the registration event
	 * @throws NoSuchEventException if a registration event with the primary key could not be found
	 */
	@Override
	public RegistrationEvent findByPrimaryKey(long registrationEventId)
		throws NoSuchEventException {

		return findByPrimaryKey((Serializable)registrationEventId);
	}

	/**
	 * Returns the registration event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registrationEventId the primary key of the registration event
	 * @return the registration event, or <code>null</code> if a registration event with the primary key could not be found
	 */
	@Override
	public RegistrationEvent fetchByPrimaryKey(long registrationEventId) {
		return fetchByPrimaryKey((Serializable)registrationEventId);
	}

	/**
	 * Returns all the registration events.
	 *
	 * @return the registration events
	 */
	@Override
	public List<RegistrationEvent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<RegistrationEvent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<RegistrationEvent> findAll(
		int start, int end,
		OrderByComparator<RegistrationEvent> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<RegistrationEvent> findAll(
		int start, int end,
		OrderByComparator<RegistrationEvent> orderByComparator,
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

		List<RegistrationEvent> list = null;

		if (useFinderCache) {
			list = (List<RegistrationEvent>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REGISTRATIONEVENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REGISTRATIONEVENT;

				sql = sql.concat(RegistrationEventModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RegistrationEvent>)QueryUtil.list(
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
	 * Removes all the registration events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RegistrationEvent registrationEvent : findAll()) {
			remove(registrationEvent);
		}
	}

	/**
	 * Returns the number of registration events.
	 *
	 * @return the number of registration events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_REGISTRATIONEVENT);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "registrationEventId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REGISTRATIONEVENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RegistrationEventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the registration event persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new RegistrationEventModelArgumentsResolver(),
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
		entityCache.removeCache(RegistrationEventImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	@Override
	@Reference(
		target = RegistrationPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = RegistrationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = RegistrationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_REGISTRATIONEVENT =
		"SELECT registrationEvent FROM RegistrationEvent registrationEvent";

	private static final String _SQL_COUNT_REGISTRATIONEVENT =
		"SELECT COUNT(registrationEvent) FROM RegistrationEvent registrationEvent";

	private static final String _ORDER_BY_ENTITY_ALIAS = "registrationEvent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RegistrationEvent exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RegistrationEventPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class RegistrationEventModelArgumentsResolver
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

			RegistrationEventModelImpl registrationEventModelImpl =
				(RegistrationEventModelImpl)baseModel;

			long columnBitmask = registrationEventModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					registrationEventModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						registrationEventModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					registrationEventModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return RegistrationEventImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return RegistrationEventTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			RegistrationEventModelImpl registrationEventModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						registrationEventModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = registrationEventModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}