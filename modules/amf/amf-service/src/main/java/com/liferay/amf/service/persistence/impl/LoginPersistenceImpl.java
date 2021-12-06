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

import com.liferay.amf.exception.NoSuchLoginException;
import com.liferay.amf.model.Login;
import com.liferay.amf.model.LoginTable;
import com.liferay.amf.model.impl.LoginImpl;
import com.liferay.amf.model.impl.LoginModelImpl;
import com.liferay.amf.service.persistence.LoginPersistence;
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
 * The persistence implementation for the login service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Queiroz
 * @generated
 */
@Component(service = {LoginPersistence.class, BasePersistence.class})
public class LoginPersistenceImpl
	extends BasePersistenceImpl<Login> implements LoginPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LoginUtil</code> to access the login persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LoginImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public LoginPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Login.class);

		setModelImplClass(LoginImpl.class);
		setModelPKClass(long.class);

		setTable(LoginTable.INSTANCE);
	}

	/**
	 * Caches the login in the entity cache if it is enabled.
	 *
	 * @param login the login
	 */
	@Override
	public void cacheResult(Login login) {
		entityCache.putResult(LoginImpl.class, login.getPrimaryKey(), login);
	}

	/**
	 * Caches the logins in the entity cache if it is enabled.
	 *
	 * @param logins the logins
	 */
	@Override
	public void cacheResult(List<Login> logins) {
		for (Login login : logins) {
			if (entityCache.getResult(LoginImpl.class, login.getPrimaryKey()) ==
					null) {

				cacheResult(login);
			}
		}
	}

	/**
	 * Clears the cache for all logins.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LoginImpl.class);

		finderCache.clearCache(LoginImpl.class);
	}

	/**
	 * Clears the cache for the login.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Login login) {
		entityCache.removeResult(LoginImpl.class, login);
	}

	@Override
	public void clearCache(List<Login> logins) {
		for (Login login : logins) {
			entityCache.removeResult(LoginImpl.class, login);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LoginImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LoginImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new login with the primary key. Does not add the login to the database.
	 *
	 * @param loginId the primary key for the new login
	 * @return the new login
	 */
	@Override
	public Login create(long loginId) {
		Login login = new LoginImpl();

		login.setNew(true);
		login.setPrimaryKey(loginId);

		login.setCompanyId(CompanyThreadLocal.getCompanyId());

		return login;
	}

	/**
	 * Removes the login with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loginId the primary key of the login
	 * @return the login that was removed
	 * @throws NoSuchLoginException if a login with the primary key could not be found
	 */
	@Override
	public Login remove(long loginId) throws NoSuchLoginException {
		return remove((Serializable)loginId);
	}

	/**
	 * Removes the login with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the login
	 * @return the login that was removed
	 * @throws NoSuchLoginException if a login with the primary key could not be found
	 */
	@Override
	public Login remove(Serializable primaryKey) throws NoSuchLoginException {
		Session session = null;

		try {
			session = openSession();

			Login login = (Login)session.get(LoginImpl.class, primaryKey);

			if (login == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoginException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(login);
		}
		catch (NoSuchLoginException noSuchEntityException) {
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
	protected Login removeImpl(Login login) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(login)) {
				login = (Login)session.get(
					LoginImpl.class, login.getPrimaryKeyObj());
			}

			if (login != null) {
				session.delete(login);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (login != null) {
			clearCache(login);
		}

		return login;
	}

	@Override
	public Login updateImpl(Login login) {
		boolean isNew = login.isNew();

		if (!(login instanceof LoginModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(login.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(login);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in login proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Login implementation " +
					login.getClass());
		}

		LoginModelImpl loginModelImpl = (LoginModelImpl)login;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (login.getCreateDate() == null)) {
			if (serviceContext == null) {
				login.setCreateDate(date);
			}
			else {
				login.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!loginModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				login.setModifiedDate(date);
			}
			else {
				login.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(login);
			}
			else {
				login = (Login)session.merge(login);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(LoginImpl.class, login, false, true);

		if (isNew) {
			login.setNew(false);
		}

		login.resetOriginalValues();

		return login;
	}

	/**
	 * Returns the login with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the login
	 * @return the login
	 * @throws NoSuchLoginException if a login with the primary key could not be found
	 */
	@Override
	public Login findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoginException {

		Login login = fetchByPrimaryKey(primaryKey);

		if (login == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoginException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return login;
	}

	/**
	 * Returns the login with the primary key or throws a <code>NoSuchLoginException</code> if it could not be found.
	 *
	 * @param loginId the primary key of the login
	 * @return the login
	 * @throws NoSuchLoginException if a login with the primary key could not be found
	 */
	@Override
	public Login findByPrimaryKey(long loginId) throws NoSuchLoginException {
		return findByPrimaryKey((Serializable)loginId);
	}

	/**
	 * Returns the login with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loginId the primary key of the login
	 * @return the login, or <code>null</code> if a login with the primary key could not be found
	 */
	@Override
	public Login fetchByPrimaryKey(long loginId) {
		return fetchByPrimaryKey((Serializable)loginId);
	}

	/**
	 * Returns all the logins.
	 *
	 * @return the logins
	 */
	@Override
	public List<Login> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Login> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Login> findAll(
		int start, int end, OrderByComparator<Login> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Login> findAll(
		int start, int end, OrderByComparator<Login> orderByComparator,
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

		List<Login> list = null;

		if (useFinderCache) {
			list = (List<Login>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LOGIN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LOGIN;

				sql = sql.concat(LoginModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Login>)QueryUtil.list(
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
	 * Removes all the logins from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Login login : findAll()) {
			remove(login);
		}
	}

	/**
	 * Returns the number of logins.
	 *
	 * @return the number of logins
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LOGIN);

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
		return "loginId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOGIN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LoginModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the login persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new LoginModelArgumentsResolver(),
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
		entityCache.removeCache(LoginImpl.class.getName());

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

	private static final String _SQL_SELECT_LOGIN =
		"SELECT login FROM Login login";

	private static final String _SQL_COUNT_LOGIN =
		"SELECT COUNT(login) FROM Login login";

	private static final String _ORDER_BY_ENTITY_ALIAS = "login.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Login exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		LoginPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"password"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class LoginModelArgumentsResolver
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

			LoginModelImpl loginModelImpl = (LoginModelImpl)baseModel;

			long columnBitmask = loginModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(loginModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= loginModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(loginModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return LoginImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return LoginTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			LoginModelImpl loginModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = loginModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = loginModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}