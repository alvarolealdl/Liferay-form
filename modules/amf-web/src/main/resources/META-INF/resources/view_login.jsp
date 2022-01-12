<%@ include file="/META-INF/resources/init.jsp" %>
<%@include file="/META-INF/resources/entry_login.jsp"%>

<h1 class="title"><liferay-ui:message key="login.capition" /></h1>

<c:if test="<%=!themeDisplay.isSignedIn()%>">

    <aui:button-row>
        <aui:button  onClick="modal2()" value="Sign In"/>
    </aui:button-row>

</c:if>

<aui:script>
        var login = document.getElementById("entry_login").innerHTML;
        function modal2 () {
            Liferay.Util.openModal({
                title:"Login Acme Movie Fanatics",
                bodyHTML: login
            });
        }
</aui:script>

