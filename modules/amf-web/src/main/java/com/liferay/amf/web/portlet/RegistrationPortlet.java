package com.liferay.amf.web.portlet;

import com.liferay.amf.web.constants.AcmeMoviePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bruno Queiroz
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=category.registration",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instance=false",
			"javax.portlet.display-name=Registration",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + AcmeMoviePortletKeys.REGISTRATION,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.init-param.add-process-action-success-action=false"

	},
	service = Portlet.class
)
public class RegistrationPortlet extends MVCPortlet {
}