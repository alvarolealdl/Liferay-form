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

package com.liferay.amf.model.impl;

import com.liferay.amf.model.RegistrationEvent;
import com.liferay.amf.model.RegistrationEventModel;
import com.liferay.amf.model.RegistrationEventSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the RegistrationEvent service. Represents a row in the &quot;Registration_RegistrationEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>RegistrationEventModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RegistrationEventImpl}.
 * </p>
 *
 * @author Bruno Queiroz
 * @see RegistrationEventImpl
 * @generated
 */
@JSON(strict = true)
public class RegistrationEventModelImpl
	extends BaseModelImpl<RegistrationEvent> implements RegistrationEventModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a registration event model instance should use the <code>RegistrationEvent</code> interface instead.
	 */
	public static final String TABLE_NAME = "Registration_RegistrationEvent";

	public static final Object[][] TABLE_COLUMNS = {
		{"registrationEventId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"eventType", Types.VARCHAR},
		{"ipAddress", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("registrationEventId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("eventType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ipAddress", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Registration_RegistrationEvent (registrationEventId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,eventType VARCHAR(75) null,ipAddress VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table Registration_RegistrationEvent";

	public static final String ORDER_BY_JPQL =
		" ORDER BY registrationEvent.registrationEventId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Registration_RegistrationEvent.registrationEventId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long REGISTRATIONEVENTID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static RegistrationEvent toModel(RegistrationEventSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		RegistrationEvent model = new RegistrationEventImpl();

		model.setRegistrationEventId(soapModel.getRegistrationEventId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setEventType(soapModel.getEventType());
		model.setIpAddress(soapModel.getIpAddress());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<RegistrationEvent> toModels(
		RegistrationEventSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<RegistrationEvent> models = new ArrayList<RegistrationEvent>(
			soapModels.length);

		for (RegistrationEventSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public RegistrationEventModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _registrationEventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRegistrationEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _registrationEventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RegistrationEvent.class;
	}

	@Override
	public String getModelClassName() {
		return RegistrationEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<RegistrationEvent, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<RegistrationEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RegistrationEvent, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((RegistrationEvent)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<RegistrationEvent, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<RegistrationEvent, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(RegistrationEvent)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<RegistrationEvent, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<RegistrationEvent, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, RegistrationEvent>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			RegistrationEvent.class.getClassLoader(), RegistrationEvent.class,
			ModelWrapper.class);

		try {
			Constructor<RegistrationEvent> constructor =
				(Constructor<RegistrationEvent>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<RegistrationEvent, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<RegistrationEvent, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<RegistrationEvent, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<RegistrationEvent, Object>>();
		Map<String, BiConsumer<RegistrationEvent, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<RegistrationEvent, ?>>();

		attributeGetterFunctions.put(
			"registrationEventId", RegistrationEvent::getRegistrationEventId);
		attributeSetterBiConsumers.put(
			"registrationEventId",
			(BiConsumer<RegistrationEvent, Long>)
				RegistrationEvent::setRegistrationEventId);
		attributeGetterFunctions.put("groupId", RegistrationEvent::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<RegistrationEvent, Long>)RegistrationEvent::setGroupId);
		attributeGetterFunctions.put(
			"companyId", RegistrationEvent::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<RegistrationEvent, Long>)
				RegistrationEvent::setCompanyId);
		attributeGetterFunctions.put("userId", RegistrationEvent::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<RegistrationEvent, Long>)RegistrationEvent::setUserId);
		attributeGetterFunctions.put(
			"userName", RegistrationEvent::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<RegistrationEvent, String>)
				RegistrationEvent::setUserName);
		attributeGetterFunctions.put(
			"createDate", RegistrationEvent::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<RegistrationEvent, Date>)
				RegistrationEvent::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", RegistrationEvent::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<RegistrationEvent, Date>)
				RegistrationEvent::setModifiedDate);
		attributeGetterFunctions.put(
			"eventType", RegistrationEvent::getEventType);
		attributeSetterBiConsumers.put(
			"eventType",
			(BiConsumer<RegistrationEvent, String>)
				RegistrationEvent::setEventType);
		attributeGetterFunctions.put(
			"ipAddress", RegistrationEvent::getIpAddress);
		attributeSetterBiConsumers.put(
			"ipAddress",
			(BiConsumer<RegistrationEvent, String>)
				RegistrationEvent::setIpAddress);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getRegistrationEventId() {
		return _registrationEventId;
	}

	@Override
	public void setRegistrationEventId(long registrationEventId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_registrationEventId = registrationEventId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getEventType() {
		if (_eventType == null) {
			return "";
		}
		else {
			return _eventType;
		}
	}

	@Override
	public void setEventType(String eventType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_eventType = eventType;
	}

	@JSON
	@Override
	public String getIpAddress() {
		if (_ipAddress == null) {
			return "";
		}
		else {
			return _ipAddress;
		}
	}

	@Override
	public void setIpAddress(String ipAddress) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ipAddress = ipAddress;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), RegistrationEvent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RegistrationEvent toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, RegistrationEvent>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RegistrationEventImpl registrationEventImpl =
			new RegistrationEventImpl();

		registrationEventImpl.setRegistrationEventId(getRegistrationEventId());
		registrationEventImpl.setGroupId(getGroupId());
		registrationEventImpl.setCompanyId(getCompanyId());
		registrationEventImpl.setUserId(getUserId());
		registrationEventImpl.setUserName(getUserName());
		registrationEventImpl.setCreateDate(getCreateDate());
		registrationEventImpl.setModifiedDate(getModifiedDate());
		registrationEventImpl.setEventType(getEventType());
		registrationEventImpl.setIpAddress(getIpAddress());

		registrationEventImpl.resetOriginalValues();

		return registrationEventImpl;
	}

	@Override
	public RegistrationEvent cloneWithOriginalValues() {
		return null;
	}

	@Override
	public int compareTo(RegistrationEvent registrationEvent) {
		long primaryKey = registrationEvent.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RegistrationEvent)) {
			return false;
		}

		RegistrationEvent registrationEvent = (RegistrationEvent)object;

		long primaryKey = registrationEvent.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<RegistrationEvent> toCacheModel() {
		RegistrationEventCacheModel registrationEventCacheModel =
			new RegistrationEventCacheModel();

		registrationEventCacheModel.registrationEventId =
			getRegistrationEventId();

		registrationEventCacheModel.groupId = getGroupId();

		registrationEventCacheModel.companyId = getCompanyId();

		registrationEventCacheModel.userId = getUserId();

		registrationEventCacheModel.userName = getUserName();

		String userName = registrationEventCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			registrationEventCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			registrationEventCacheModel.createDate = createDate.getTime();
		}
		else {
			registrationEventCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			registrationEventCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			registrationEventCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		registrationEventCacheModel.eventType = getEventType();

		String eventType = registrationEventCacheModel.eventType;

		if ((eventType != null) && (eventType.length() == 0)) {
			registrationEventCacheModel.eventType = null;
		}

		registrationEventCacheModel.ipAddress = getIpAddress();

		String ipAddress = registrationEventCacheModel.ipAddress;

		if ((ipAddress != null) && (ipAddress.length() == 0)) {
			registrationEventCacheModel.ipAddress = null;
		}

		return registrationEventCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<RegistrationEvent, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<RegistrationEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RegistrationEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((RegistrationEvent)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<RegistrationEvent, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<RegistrationEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RegistrationEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((RegistrationEvent)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, RegistrationEvent>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _registrationEventId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _eventType;
	private String _ipAddress;

	public <T> T getColumnValue(String columnName) {
		Function<RegistrationEvent, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((RegistrationEvent)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("registrationEventId", _registrationEventId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("eventType", _eventType);
		_columnOriginalValues.put("ipAddress", _ipAddress);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("registrationEventId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("eventType", 128L);

		columnBitmasks.put("ipAddress", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private RegistrationEvent _escapedModel;

}