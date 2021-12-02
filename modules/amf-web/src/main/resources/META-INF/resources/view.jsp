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
--%>

<%@ include file="/META-INF/resources/init.jsp" %>

<h1><liferay-ui:message key="registration.caption" /></h1>

<portlet:actionURL name="<%= MCVCommandNames.ADD_REGISTRATION %>" var="addRegistrationURL" />

<c:if test="<%= !themeDisplay.isSignedIn() %>">
	<aui:form action="<%= addRegistrationURL %>" method="post" name="amfRegistration">
		<aui:input
			label="First Name"
			name="firstName"
			type="text"
			value="First Name"
		/>

		<aui:input
			label="Last Name"
			name="lastName"
			type="text"
			value="Last Name"
		/>

		<aui:input
			label="Email Address"
			name="emailAddress"
			type="text"
			value="Email Address"
		/>

		<aui:input
			label="UserName"
			name="userName"
			type="text"
			value="UserName"
		/>

		<aui:input label="Gender" name="gender" type="checkbox" />

		<aui:input
			label="Birthday"
			name="Birthday"
			type="date"
			value="Birthday"
		/>

		<aui:input
			label="Password"
			name="password"
			type="text"
			value="Password"
		/>

		<aui:input
			label=" Confirm Password"
			name="confirmPassword"
			type="text"
			value="Confirm Password"
		/>

		<aui:input
			label="Home Phone"
			name="homePhone"
			type="text"
			value="Home Phone"
		/>

		<aui:input
			label="Mobile Phone"
			name="mobilePhone"
			type="text"
			value="Mobile Phone"
		/>

		<aui:input
			label="Address 1"
			name="address1"
			type="text"
			value="Address 1"
		/>

		<aui:input
			label="Address 2"
			name="address2"
			type="text"
			value="Address 2"
		/>

		<aui:input
			label="City"
			name="city"
			type="text"
			value="City"
		/>

		<aui:input
			label="State"
			name="state"
			type="text"
			value="State"
		/>

		<aui:input
			label="Zip Code"
			name="zipCode"
			type="number"
			value="Zip Code"
		/>

		<aui:select label="Security Question" name="security-question">
			<aui:option value="Option 1">What is your mother's maiden name?</aui:option>
			<aui:option value="Option 2">What is the make of your first car?</aui:option>
			<aui:option value="Option 3">What is your high school mascot?</aui:option>
			<aui:option value="Option 3">Who is your favorite actor?</aui:option>
		</aui:select>

		<aui:input
			label="Answer"
			name="answer"
			type="text"
			value="Answer"
		/>

		<aui:input label="Term of Use" name="termOfUse" type="checkbox" />

		<!--Buttons-->
		<liferay-frontend:edit-form-footer>
			<aui:button type="submit" value="save" />

			<aui:button href='<%= ParamUtil.getString(request, "backURL") %>' type="cancel" />
		</liferay-frontend:edit-form-footer>
	</aui:form>
</c:if>

<input name="redirect" type="hidden" value="<%= currentURL %>" />