package com.liferay.amf.web.portlet.action;

import com.liferay.amf.web.constants.MCVCommandNames;
import com.liferay.amf.web.constants.RegistrationPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(

        immediate = true,
        property = {
                "javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
                "mvc.command.name=" + MCVCommandNames.VIEW_REGISTRATION
        },
        service = MVCRenderCommand.class

)
public class AddRegistrationMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if(!themeDisplay.isSignedIn()){
            return "view.jsp";
        }
        return null;

    }

}