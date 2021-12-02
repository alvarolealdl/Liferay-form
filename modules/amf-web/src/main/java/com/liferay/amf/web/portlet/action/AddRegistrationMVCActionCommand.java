package com.liferay.amf.web.portlet.action;

import com.liferay.amf.exception.RegistrationValidationExceptionException;
import com.liferay.amf.model.Registration;
import com.liferay.amf.service.RegistrationService;
import com.liferay.amf.web.constants.MCVCommandNames;
import com.liferay.amf.web.constants.RegistrationPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for adding user.
 *
 * @author Bruno Queiroz
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
		"mvc.command.name=" + MCVCommandNames.ADD_REGISTRATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = MVCActionCommand.class
)
public class AddRegistrationMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Registration.class.getName(), actionRequest);

		long groupId = serviceContext.getScopeGroupId();

		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String emailAddress = ParamUtil.getString(
			actionRequest, "emailAddress");
		String userName = ParamUtil.getString(actionRequest, "userName");
		String gender = ParamUtil.getString(actionRequest, "gender");
		Date birthday = ParamUtil.getDate(
			actionRequest, "birthday", new SimpleDateFormat("yyyy-MM-dd"));
		String password = ParamUtil.getString(actionRequest, "password");
		String confirmPassword = ParamUtil.getString(
			actionRequest, "confirmPassword");
		String homePhone = ParamUtil.getString(actionRequest, "homePhone");
		String mobilePhone = ParamUtil.getString(actionRequest, "mobilePhone");
		String address1 = ParamUtil.getString(actionRequest, "address1");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		long zipCode = ParamUtil.getLong(actionRequest, "zipCode");
		String securityAnswer = ParamUtil.getString(actionRequest, "answer");

		try {
			_registrationService.addRegistration(
				groupId, userName, firstName, lastName, emailAddress, gender,
				birthday, password, homePhone, mobilePhone, address1, address2,
				city, state, zipCode, securityAnswer);

			SessionMessages.add(actionRequest, "addRegistration");
		}
                catch (RegistrationValidationExceptionException e ){{
				SessionErrors.add(actionRequest, "emailAddressValidation");

                        }
		}
	}

	@Reference
	protected RegistrationService _registrationService;

}