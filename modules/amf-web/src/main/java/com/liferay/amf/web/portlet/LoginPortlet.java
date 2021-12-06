package com.liferay.amf.web.portlet;

import com.liferay.amf.web.constants.AcmeMoviePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.login",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instance=false",
                "javax.portlet.display-name=Login",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/entry_login.jsp",
                "javax.portlet.name=" + AcmeMoviePortletKeys.LOGIN,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.init-param.add-process-action-success-action=false"

        },
        service = Portlet.class
)
public class LoginPortlet extends MVCPortlet {
}
