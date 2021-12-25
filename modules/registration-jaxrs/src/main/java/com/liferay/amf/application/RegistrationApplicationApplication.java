package com.liferay.amf.application;

import com.liferay.amf.model.Registration;
import com.liferay.amf.service.RegistrationService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Set;

/**
 * @author Bruno Queiroz
 */
@Component(
		property = {
				JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/registrations",
				JaxrsWhiteboardConstants.JAX_RS_NAME + "=Registration.Rest"
		},
		service = Application.class
)
public class RegistrationApplicationApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addRegistration(@Context HttpServletRequest request, String body) {

		Registration registration = JSONFactoryUtil.looseDeserialize(body, Registration.class);

		registration = _registrationService.addRegistration(registration);

		return Response.ok(JSONFactoryUtil.looseSerialize(registration)).build();

	}

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRegistration(@Context HttpServletRequest request, @PathParam("id") long id) throws PortalException {

		Registration registration = _registrationService.getRegistration(id);

		if(Validator.isNull(registration)) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		_registrationService.deleteRegistration(id);
		return Response.status(Response.Status.NO_CONTENT).build();

	}


	@Reference
	private RegistrationService _registrationService;
}

