package com.liferay.amf.web.internal.security.permission.resource;

import com.liferay.amf.model.Registration;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = RegistrationPermission.class
)
public class RegistrationPermission {

    public static boolean contains(PermissionChecker permissionChecker, Registration registration, String actionId)
    throws PortalException {

        return _registrationModelResourcePermission.contains(permissionChecker, registration, actionId);

    }

    @Reference(
            target = "(model.class.name=com.liferay.amf.model.Registration)",
            unbind = "-"
    )
    protected void setEntryModelPermission(
            ModelResourcePermission<Registration> modelResourcePermission) {
        _registrationModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Registration>
            _registrationModelResourcePermission;
}


