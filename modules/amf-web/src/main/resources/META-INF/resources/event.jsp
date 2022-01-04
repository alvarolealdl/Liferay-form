<%@ include file="/META-INF/resources/init.jsp" %>

<%
    List<Registration> registrations = RegistrationLocalServiceUtil.getAllRegistrations();

    ServiceContext serviceContext =  ServiceContextFactory.getInstance(Registration.class.getName(), request);

    List<RegistrationEvent> events = RegistrationEventLocalServiceUtil.getAllEvents();

%>
<div class="container">
    <liferay-ui:tabs
            names="<%= "all-logs,registration-logs,login-logs"%>"
            refresh="<%= false %>"
            type="tabs nav-tabs-default"
            cssClass="table"
    >
        <div class="content">
            <liferay-ui:section>
                <liferay-ui:search-container
                        curParam="<%= "all-logs"%>"
                        delta="2"
                        deltaConfigurable="false"
                        emptyResultsMessage=""
                        total="<%=events.size()%>"
                >
                    <liferay-ui:search-container-row className="com.liferay.amf.model.RegistrationEvent" modelVar="event">
                        <liferay-ui:search-container-column-text name="date" value="<%=event.getCreateDate()%>" />
                        <liferay-ui:search-container-column-text name="user-name" value="<%=event.getUserName()%>" />
                        <liferay-ui:search-container-column-text name="id-address" value="<%=event.getIpAddress()%>" />
                        <liferay-ui:search-container-column-text name="event-type" value="<%=event.getEventType()%>" />
                    </liferay-ui:search-container-row>
                </liferay-ui:search-container>
            </liferay-ui:section>

            <liferay-ui:section>
                <liferay-ui:search-container
                        curParam="<%= "registration-logs"%>"
                        delta="2"
                        deltaConfigurable="false"
                        emptyResultsMessage="No logs found"
                        total="<%=registrations.size()%>"
                >
                    <liferay-ui:search-container-row className="com.liferay.amf.model.Registration" modelVar="registration">
                        <liferay-ui:search-container-column-text name="date" value="<%=registration.getCreateDate()%>" />
                        <liferay-ui:search-container-column-text name="user-name" value="<%=registration.getUserName()%>" />
                        <liferay-ui:search-container-column-text name="id-address" value="<%=serviceContext.getRemoteAddr()%>" />
                        <liferay-ui:search-container-column-text name="event" value="registration" />
                    </liferay-ui:search-container-row>
                </liferay-ui:search-container>
            </liferay-ui:section>


            <liferay-ui:section>
                <liferay-ui:search-container
                        curParam="<%= "login-logs"%>"
                        delta="2"
                        deltaConfigurable="false"
                        emptyResultsMessage=""
                >
                    <liferay-ui:search-container-row className="com.liferay.amf.model.Login" modelVar="login">
                        <liferay-ui:search-container-column-text name="date" value="<%=login.getCreateDate()%>" />
                        <liferay-ui:search-container-column-text name="user-name" value="<%=RegistrationLocalServiceUtil.getById(themeDisplay.getUserId()).getUserName()%>" />
                        <liferay-ui:search-container-column-text name="id-address" value="<%=serviceContext.getRemoteAddr()%>" />
                        <liferay-ui:search-container-column-text name="event" value="login" />
                    </liferay-ui:search-container-row>
                </liferay-ui:search-container>
            </liferay-ui:section>
        </div>
    </liferay-ui:tabs>
</div>