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

import com.liferay.amf.model.Login;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Login in entity cache.
 *
 * @author Bruno Queiroz
 * @generated
 */
public class LoginCacheModel implements CacheModel<Login>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LoginCacheModel)) {
			return false;
		}

		LoginCacheModel loginCacheModel = (LoginCacheModel)object;

		if (loginId == loginCacheModel.loginId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, loginId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{loginId=");
		sb.append(loginId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", password=");
		sb.append(password);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Login toEntityModel() {
		LoginImpl loginImpl = new LoginImpl();

		loginImpl.setLoginId(loginId);
		loginImpl.setGroupId(groupId);
		loginImpl.setCompanyId(companyId);
		loginImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			loginImpl.setCreateDate(null);
		}
		else {
			loginImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			loginImpl.setModifiedDate(null);
		}
		else {
			loginImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (emailAddress == null) {
			loginImpl.setEmailAddress("");
		}
		else {
			loginImpl.setEmailAddress(emailAddress);
		}

		if (password == null) {
			loginImpl.setPassword("");
		}
		else {
			loginImpl.setPassword(password);
		}

		loginImpl.resetOriginalValues();

		return loginImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		loginId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		password = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(loginId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}
	}

	public long loginId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String emailAddress;
	public String password;

}