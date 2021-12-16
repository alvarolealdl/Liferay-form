package com.liferay.amf.application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/registration",
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

		return null;

	}

}