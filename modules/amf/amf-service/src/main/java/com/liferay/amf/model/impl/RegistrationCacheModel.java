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

import com.liferay.amf.model.Registration;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Registration in entity cache.
 *
 * @author Bruno Queiroz
 * @generated
 */
public class RegistrationCacheModel
	implements CacheModel<Registration>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RegistrationCacheModel)) {
			return false;
		}

		RegistrationCacheModel registrationCacheModel =
			(RegistrationCacheModel)object;

		if (amfRegistrationId == registrationCacheModel.amfRegistrationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amfRegistrationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{amfRegistrationId=");
		sb.append(amfRegistrationId);
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
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", male=");
		sb.append(male);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", password=");
		sb.append(password);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", securityAnswer=");
		sb.append(securityAnswer);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Registration toEntityModel() {
		RegistrationImpl registrationImpl = new RegistrationImpl();

		registrationImpl.setAmfRegistrationId(amfRegistrationId);
		registrationImpl.setGroupId(groupId);
		registrationImpl.setCompanyId(companyId);
		registrationImpl.setUserId(userId);

		if (userName == null) {
			registrationImpl.setUserName("");
		}
		else {
			registrationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			registrationImpl.setCreateDate(null);
		}
		else {
			registrationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			registrationImpl.setModifiedDate(null);
		}
		else {
			registrationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			registrationImpl.setFirstName("");
		}
		else {
			registrationImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			registrationImpl.setLastName("");
		}
		else {
			registrationImpl.setLastName(lastName);
		}

		if (emailAddress == null) {
			registrationImpl.setEmailAddress("");
		}
		else {
			registrationImpl.setEmailAddress(emailAddress);
		}

		registrationImpl.setMale(male);

		if (birthday == Long.MIN_VALUE) {
			registrationImpl.setBirthday(null);
		}
		else {
			registrationImpl.setBirthday(new Date(birthday));
		}

		if (password == null) {
			registrationImpl.setPassword("");
		}
		else {
			registrationImpl.setPassword(password);
		}

		if (homePhone == null) {
			registrationImpl.setHomePhone("");
		}
		else {
			registrationImpl.setHomePhone(homePhone);
		}

		if (mobilePhone == null) {
			registrationImpl.setMobilePhone("");
		}
		else {
			registrationImpl.setMobilePhone(mobilePhone);
		}

		if (address1 == null) {
			registrationImpl.setAddress1("");
		}
		else {
			registrationImpl.setAddress1(address1);
		}

		if (address2 == null) {
			registrationImpl.setAddress2("");
		}
		else {
			registrationImpl.setAddress2(address2);
		}

		if (city == null) {
			registrationImpl.setCity("");
		}
		else {
			registrationImpl.setCity(city);
		}

		if (state == null) {
			registrationImpl.setState("");
		}
		else {
			registrationImpl.setState(state);
		}

		registrationImpl.setZipCode(zipCode);

		if (securityAnswer == null) {
			registrationImpl.setSecurityAnswer("");
		}
		else {
			registrationImpl.setSecurityAnswer(securityAnswer);
		}

		registrationImpl.resetOriginalValues();

		return registrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		amfRegistrationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();

		male = objectInput.readBoolean();
		birthday = objectInput.readLong();
		password = objectInput.readUTF();
		homePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();

		zipCode = objectInput.readLong();
		securityAnswer = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(amfRegistrationId);

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

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeBoolean(male);
		objectOutput.writeLong(birthday);

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (homePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(homePhone);
		}

		if (mobilePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		if (address1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address1);
		}

		if (address2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address2);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeLong(zipCode);

		if (securityAnswer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(securityAnswer);
		}
	}

	public long amfRegistrationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String emailAddress;
	public boolean male;
	public long birthday;
	public String password;
	public String homePhone;
	public String mobilePhone;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public long zipCode;
	public String securityAnswer;

}