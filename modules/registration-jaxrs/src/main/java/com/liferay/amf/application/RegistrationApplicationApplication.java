package com.liferay.amf.application;

import com.liferay.amf.exception.RegistrationValidationExceptionException;
import com.liferay.amf.model.Registration;
import com.liferay.amf.service.RegistrationService;
import com.liferay.batch.engine.pagination.Page;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;


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
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRegistration(@Context HttpServletRequest request, @PathParam("id") long id) throws PortalException {

		Registration registration = _registrationService.getRegistration(id);

		if(Validator.isNull(registration)) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(JSONFactoryUtil.looseSerialize(registration)).build();


	}
	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRegistrations(@Context HttpServletRequest request){
		_logger.debug("Getting all registrations that are available...");

		try {
			List<Registration> registrations = _registrationService.getAllRegistrations();

			if(registrations.isEmpty()){
				throw new RegistrationValidationExceptionException("NO REGISTRATION AVAILABLE");
			}
			_logger.info(registrations.size() + "registration available");

			return Response.ok(Page.of(registrations)).build();

		}
		catch (Exception e){
			_logger.error(new Date() + " :: " + _logger.getName() + " :: " + e.getMessage());

			return Response.status(
					Response.Status.BAD_REQUEST.getStatusCode()
			).entity(
					e.getMessage()
			).build();

		}

	}

	private static final Logger _logger = LoggerFactory.getLogger(Registration.class.getName());

	@Reference
	private RegistrationService _registrationService;
}

