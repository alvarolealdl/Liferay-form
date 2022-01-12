<%@ include file="/META-INF/resources/init.jsp" %>

<portlet:actionURL name="<%=MCVCommandNames.ACCESS_LOGIN%>" var="loginURL"/>

<portlet:renderURL var="backToHomeURL">
    <portlet:param name="mvcPath" value="/view_login.jsp"/>
</portlet:renderURL>

<h1><liferay-ui:message key="login.capition" /></h1>

<div id="entry_login" style="display: none" >
    <aui:form action="loginURL" method="post" name="amfLogin">
        <aui:input label="Email Address" name="emailAddress" type="text" placeholder="Email Address">
            <aui:validator name="required"/>
            <aui:validator name="maxLength">255</aui:validator>
        </aui:input>

        <aui:input label="Password" name="password" type="password" placeholder="Password">
            <aui:validator name="required"/>
            <aui:validator name="minLength">6</aui:validator>
        </aui:input>

        <liferay-frontend:edit-form-footer>
            <aui:button type="submit" value="save" />

            <aui:button onClick="<%= backToHomeURL.toString()%>" type="cancel" />
        </liferay-frontend:edit-form-footer>

    </aui:form>
</div>
