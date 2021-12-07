
<%@ include file="/META-INF/resources/init.jsp" %>

<h1><liferay-ui:message key="registration.caption" /></h1>

<portlet:actionURL name="<%=MCVCommandNames.ADD_REGISTRATION%>" var="addRegistrationURL" />

<c:if test="<%= !themeDisplay.isSignedIn() %>">
	<aui:form action="<%= addRegistrationURL %>" method="post" name="amfRegistration">

		<aui:input label="First Name" name="firstName" type="text" placeholder="First Name">
			<aui:validator name="required"/>
			<aui:validator name="maxLength">50</aui:validator>
		</aui:input>

		<aui:input label="Last Name" name="lastName" type="text" placeholder="Last Name">
			<aui:validator name="required"/>
			<aui:validator name="maxLength">50</aui:validator>
		</aui:input>

		<aui:input label="Email Address" name="emailAddress" type="text" placeholder="Email Address">
			<aui:validator name="required"/>
			<aui:validator name="maxLength">255</aui:validator>
		</aui:input>

		<aui:input label="UserName" name="userName" type="text" placeholder="UserName">
			<aui:validator name="required"/>
			<aui:validator name="minLength">4</aui:validator>
			<aui:validator name="maxLength">16</aui:validator>

		</aui:input>

		<aui:input label="Male" name="gender" type="checkbox" />

		<aui:input label="Birthday" name="Birthday" type="date" placeholder="Birthday">
			<aui:validator name="required"/>
		</aui:input>

		<aui:input label="Password" name="password" type="password" placeholder="Password">
			<aui:validator name="required"/>
			<aui:validator name="minLength">6</aui:validator>
		</aui:input>

		<aui:input label=" Confirm Password" name="confirmPassword" type="password" placeholder="Confirm Password">
			<aui:validator name="equalTo">"#password"</aui:validator>
		</aui:input>

		<aui:input label="Home Phone" name="homePhone" type="text" placeholder="Home Phone">
			<aui:validator name="maxLength">10</aui:validator>
		</aui:input>

		<aui:input label="Mobile Phone" name="mobilePhone" type="text" placeholder="Mobile Phone">
			<aui:validator name="maxLength">10</aui:validator>
		</aui:input>

		<aui:input label="Address 1" name="address1" type="text" placeholder="Address 1">
			<aui:validator name="maxLength">255</aui:validator>
		</aui:input>

		<aui:input label="Address 2" name="address2" type="text" placeholder="Address 2">
			<aui:validator name="maxLength">255</aui:validator>
		</aui:input>

		<aui:input label="City" name="city" type="text" placeholder="City">
			<aui:validator name="maxLength">255</aui:validator>
		</aui:input>

		<aui:input label="State" name="state" type="text" placeholder="State">

		</aui:input>

		<aui:input label="Zip Code" name="zipCode" type="number" placeholder="Zip Code">

		</aui:input>

		<aui:select label="Security Question" name="security-question">
			<aui:option value="Option 1">What is your mother's maiden name?</aui:option>
			<aui:option value="Option 2">What is the make of your first car?</aui:option>
			<aui:option value="Option 3">What is your high school mascot?</aui:option>
			<aui:option value="Option 3">Who is your favorite actor?</aui:option>
		</aui:select>

		<aui:input label="Answer" name="answer" type="text" placeholder="Write your answer here.">
			<aui:validator name="maxLength">255</aui:validator>
		</aui:input>

		<aui:input label="Term of Use" name="termOfUse" type="checkbox" />

		<!--Buttons-->
		<liferay-frontend:edit-form-footer>
			<aui:button type="submit" value="save" />

			<aui:button href='<%= ParamUtil.getString(request, "backURL") %>' type="cancel" />
		</liferay-frontend:edit-form-footer>
	</aui:form>
</c:if>

<input name="redirect" type="hidden" value="<%= currentURL %>" />