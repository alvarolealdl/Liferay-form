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
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RegistrationEvent in entity cache.
 *
 * @author Bruno Queiroz
 * @generated
 */
public class RegistrationEventCacheModel
	implements CacheModel<RegistrationEvent>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RegistrationEventCacheModel)) {
			return false;
		}

		RegistrationEventCacheModel registrationEventCacheModel =
			(RegistrationEventCacheModel)object;

		if (registrationEventId ==
				registrationEventCacheModel.registrationEventId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, registrationEventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{registrationEventId=");
		sb.append(registrationEventId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RegistrationEvent toEntityModel() {
		RegistrationEventImpl registrationEventImpl =
			new RegistrationEventImpl();

		registrationEventImpl.setRegistrationEventId(registrationEventId);
		registrationEventImpl.setGroupId(groupId);
		registrationEventImpl.setCompanyId(companyId);
		registrationEventImpl.setUserId(userId);

		if (userName == null) {
			registrationEventImpl.setUserName("");
		}
		else {
			registrationEventImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			registrationEventImpl.setCreateDate(null);
		}
		else {
			registrationEventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			registrationEventImpl.setModifiedDate(null);
		}
		else {
			registrationEventImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (eventType == null) {
			registrationEventImpl.setEventType("");
		}
		else {
			registrationEventImpl.setEventType(eventType);
		}

		if (ipAddress == null) {
			registrationEventImpl.setIpAddress("");
		}
		else {
			registrationEventImpl.setIpAddress(ipAddress);
		}

		registrationEventImpl.resetOriginalValues();

		return registrationEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		registrationEventId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		eventType = objectInput.readUTF();
		ipAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(registrationEventId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (eventType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		if (ipAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}
	}

	public long registrationEventId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String eventType;
	public String ipAddress;

}