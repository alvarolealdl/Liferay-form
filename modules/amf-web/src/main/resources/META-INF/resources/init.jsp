<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/item-selector" prefix="liferay-item-selector" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@taglib prefix="liferay-security" uri="http://liferay.com/tld/security" %>.

<%@ page import="com.liferay.amf.web.constants.MCVCommandNames" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.amf.model.Registration" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.amf.service.RegistrationLocalServiceUtil" %>
<%@ page import="com.liferay.amf.model.RegistrationEvent" %>
<%@ page import="com.liferay.amf.service.RegistrationEventLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext" %>
<%@ page import="com.liferay.portal.kernel.service.ServiceContextFactory" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />