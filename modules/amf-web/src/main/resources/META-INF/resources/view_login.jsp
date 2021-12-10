<%@ include file="/META-INF/resources/init.jsp" %>
<%@include file="/META-INF/resources/entry_login.jsp"%>


<c:if test="<%=themeDisplay.isSignedIn()%>">
    <button  class="btn btn-link" onclick="modal2()">Sign In </button>

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

