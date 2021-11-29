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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AmfRegistration_Registration&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Registration
 * @generated
 */
public class RegistrationTable extends BaseTable<RegistrationTable> {

	public static final RegistrationTable INSTANCE = new RegistrationTable();

	public final Column<RegistrationTable, Long> amfRegistrationId =
		createColumn(
			"amfRegistrationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RegistrationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> emailAddress = createColumn(
		"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, Date> birthday = createColumn(
		"birthday", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> password = createColumn(
		"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> homePhone = createColumn(
		"homePhone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> mobilePhone = createColumn(
		"mobilePhone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> address1 = createColumn(
		"address1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> address2 = createColumn(
		"address2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> city = createColumn(
		"city", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, Long> zipCode = createColumn(
		"zipCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegistrationTable, String> securityAnswer =
		createColumn(
			"securityAnswer", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RegistrationTable() {
		super("AmfRegistration_Registration", RegistrationTable::new);
	}

}