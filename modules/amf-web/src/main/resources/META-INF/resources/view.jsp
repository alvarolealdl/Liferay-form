
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="registration.caption"/></b>
</p>

<%
	String backURL = ParamUtil.getString(request, "backURL");
%>

<portlet:actionURL name="<%=MCVCommandNames.ADD_REGISTRATION%>" var="addRegistrationURL" />

<aui:form action="<%= addRegistrationURL %>" method="post" name="amfRegistration">

	<aui:input label="First Name" name="firstName" type="text"
			   value='<%= "First Name" %>' />

	<aui:input label="Last Name" name="lastName" type="text"
			   value='<%= "Last Name" %>' />

	<aui:input label="Email Address" name="emailAddress" type="text"
			   value='<%= "Email Address" %>' />

	<aui:input label="UserName" name="userName" type="text"
			   value='<%= "UserName" %>' />

	<aui:input label="Gender" name="gender" type="text"
			   value='<%= "Gender" %>' />

	<aui:input label="Birthday" name="Birthday" type="date"
			   value='<%= "Birthday" %>' />

	<aui:input label=" Confirm Password" name="confirmPassword" type="text"
			   value='<%= "Password" %>' />

	<aui:input label="Home Phone" name="homePhone" type="text"
			   value='<%= "Home Phone" %>' />

	<aui:input label="Mobile Phone" name="mobilePhone" type="text"
			   value='<%= "Mobile Phone" %>' />

	<aui:input label="Address 1" name="address1" type="text"
			   value='<%= "Address 1" %>' />

	<aui:input label="Address 2" name="address2" type="text"
			   value='<%= "Address 2" %>' />

	<aui:input label="City" name="city" type="text"
			   value='<%= "City" %>' />

	<aui:input label="State" name="state" type="text"
			   value='<%= "State" %>' />

	<aui:input label="Zip Code" name="zipCode" type="number"
			   value='<%= "Zip Code" %>' />

	<aui:select  label="Security Question" name="security-question">
		<aui:option value="Option 1">What is your mother's maiden name?</aui:option>
		<aui:option value="Option 2">What is the make of your first car?</aui:option>
		<aui:option value="Option 3">What is your high school mascot?</aui:option>
		<aui:option value="Option 3">Who is your favorite actor?</aui:option>
	</aui:select>

	<aui:input label="Answer" name="answer" type="text"
			   value='<%= "Answer" %>' />

	<aui:input label="Term of Use" name="termOfUse" type="checkbox"/>


	<!--Buttons-->
	<liferay-frontend:edit-form-footer>
		<aui:button type="submit" />

		<aui:button href="<%= backURL %>" type="cancel" />
	</liferay-frontend:edit-form-footer>
</aui:form>