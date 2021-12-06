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

package com.liferay.amf.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.amf.service.http.LoginServiceSoap}.
 *
 * @author Bruno Queiroz
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class LoginSoap implements Serializable {

	public static LoginSoap toSoapModel(Login model) {
		LoginSoap soapModel = new LoginSoap();

		soapModel.setLoginId(model.getLoginId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setPassword(model.getPassword());

		return soapModel;
	}

	public static LoginSoap[] toSoapModels(Login[] models) {
		LoginSoap[] soapModels = new LoginSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LoginSoap[][] toSoapModels(Login[][] models) {
		LoginSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LoginSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LoginSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LoginSoap[] toSoapModels(List<Login> models) {
		List<LoginSoap> soapModels = new ArrayList<LoginSoap>(models.size());

		for (Login model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LoginSoap[soapModels.size()]);
	}

	public LoginSoap() {
	}

	public long getPrimaryKey() {
		return _loginId;
	}

	public void setPrimaryKey(long pk) {
		setLoginId(pk);
	}

	public long getLoginId() {
		return _loginId;
	}

	public void setLoginId(long loginId) {
		_loginId = loginId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	private long _loginId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _emailAddress;
	private String _password;

}