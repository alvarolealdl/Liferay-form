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
 * The table class for the &quot;Registration_RegistrationEvent&quot; database table.
 *
 * @author Bruno Queiroz
 * @see RegistrationEvent
 * @generated
 */
public class RegistrationEventTable extends BaseTable<RegistrationEventTable> {

	public static final RegistrationEventTable INSTANCE =
		new RegistrationEventTable();

	public final Column<RegistrationEventTable, Long> registrationEventId =
		createColumn(
			"registrationEventId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<RegistrationEventTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegistrationEventTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegistrationEventTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegistrationEventTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationEventTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RegistrationEventTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RegistrationEventTable, String> eventType =
		createColumn(
			"eventType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationEventTable, String> ipAddress =
		createColumn(
			"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RegistrationEventTable() {
		super("Registration_RegistrationEvent", RegistrationEventTable::new);
	}

}