package com.liferay.amf.web.portlet.action;

import com.liferay.amf.model.Registration;
import com.liferay.amf.web.constants.MCVCommandNames;
import com.liferay.amf.web.constants.RegistrationPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * MVC Action Command for adding assignments.
 *
 * @author Bruno Queiroz
 */

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
                "mvc.command.name=" + MCVCommandNames.ADD_REGISTRATION
        },
    service = MVCActionCommand.class
)
public class AddRegistrationMVCActionCommand extends BaseMVCActionCommand {

        @Override
        protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

                ServiceContext serviceContext =
                        ServiceContextFactory.getInstance(Registration.class.getName(), actionRequest);

        }
}
