package com.liferay.amf.web.portlet.action;

import com.liferay.amf.model.Registration;
import com.liferay.amf.service.RegistrationEventService;
import com.liferay.amf.service.RegistrationService;
import com.liferay.amf.web.constants.AcmeMoviePortletKeys;
import com.liferay.amf.web.constants.MCVCommandNames;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MVC Action Command for adding user.
 *
 * @author Bruno Queiroz
 */
@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AcmeMoviePortletKeys.REGISTRATION,
			"mvc.command.name=" + MCVCommandNames.ADD_REGISTRATION,
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

		String firstName = ParamUtil.getString(actionRequest, "firstName", StringPool.BLANK);
		String lastName = ParamUtil.getString(actionRequest, "lastName", StringPool.BLANK);
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress", StringPool.BLANK);
		String userName = ParamUtil.getString(actionRequest, "userName", StringPool.BLANK);
		String gender = ParamUtil.getString(actionRequest, "gender");
		Date birthday = ParamUtil.getDate(
				actionRequest, "birthday", new SimpleDateFormat("yyyy-MM-dd"));
		String password = ParamUtil.getString(actionRequest, "password", StringPool.BLANK);
		String confirmPassword = ParamUtil.getString(
				actionRequest, "confirmPassword", StringPool.BLANK);
		String homePhone = ParamUtil.getString(actionRequest, "homePhone", StringPool.BLANK);
		String mobilePhone = ParamUtil.getString(actionRequest, "mobilePhone", StringPool.BLANK);
		String address1 = ParamUtil.getString(actionRequest, "address1", StringPool.BLANK);
		String address2 = ParamUtil.getString(actionRequest, "address2", StringPool.BLANK);
		String city = ParamUtil.getString(actionRequest, "city", StringPool.BLANK);
		String state = ParamUtil.getString(actionRequest, "state", StringPool.BLANK);
		long zipCode = ParamUtil.getLong(actionRequest, "zipCode");
		String securityAnswer = ParamUtil.getString(actionRequest, "answer", StringPool.BLANK);

		boolean male = false;
		String passwordChecked = null;

		if(gender.equals("male")){
			male = true;
		}

		if (password.equals(confirmPassword)){
			passwordChecked = password;
		}

		try {
			_log.debug("Adding Registration to database...");

			 _registrationService.addRegistration(
					groupId, userName, firstName, lastName, emailAddress, male,
					birthday, passwordChecked, homePhone, mobilePhone, address1, address2,
					city, state, zipCode, securityAnswer);

			_eventTrack.addEvent(groupId, serviceContext.getCompanyId(), "registration", serviceContext.getRemoteAddr(),
					userName, new Date());

			SessionMessages.add(actionRequest, "addRegistration");
			sendRedirect(actionRequest, actionResponse);

		}
		catch (Exception e ){
			_log.error(new Date() + " :: " + _log.getClass().getName() + " :: " + e.getMessage());

			SessionErrors.add(actionRequest, "emailAddressValidation");

			actionResponse.setRenderParameter("mvcPath", "/error.jsp");


		}

	}

	@Reference
	protected RegistrationService _registrationService;

	@Reference
	private RegistrationEventService _eventTrack;

	private static final Log _log = LogFactoryUtil.getLog(AddRegistrationMVCActionCommand.class);

}



