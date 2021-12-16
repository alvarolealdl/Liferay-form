package com.liferay.amf.web.portlet.action;

import com.liferay.amf.exception.LoginValidationExceptionException;
import com.liferay.amf.model.Registration;
import com.liferay.amf.service.LoginService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;


//@Component(
//        immediate = true,
//        property = {
//                "javax.portlet.name=" + AcmeMoviePortletKeys.LOGIN,
//                "mvc.command.name=" + MCVCommandNames.ACCESS_LOGIN,
//
//        },
//        service = MVCActionCommand.class
//)
public class AcmeLoginMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Registration.class.getName(), actionRequest);

        long groupId = serviceContext.getScopeGroupId();

        String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
        String password = ParamUtil.getString(actionRequest, "password");

        if (!Validator.isBlank(password) && !Validator.isBlank(emailAddress)) {
            try {

                _loginService.addLogin(groupId, emailAddress, password);
                SessionMessages.add(actionRequest, "login-entry");

            } catch (LoginValidationExceptionException e) {

                SessionErrors.add(actionRequest, "login-validation");
                actionResponse.setRenderParameter("mcvPath", "/error.jsp");

            }


        }

    }

    @Reference
    private LoginService _loginService;
}

