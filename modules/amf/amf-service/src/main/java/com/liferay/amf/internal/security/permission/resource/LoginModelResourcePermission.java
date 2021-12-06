package com.liferay.amf.internal.security.permission.resource;

import com.liferay.amf.model.Login;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "model.class.name=com.liferay.account.model.Login",
        service = ModelResourcePermission.class
)
public class LoginModelResourcePermission implements ModelResourcePermission<Login> {
    @Override
    public void check(PermissionChecker permissionChecker, long primaryKey, String actionId) throws PortalException {

    }

    @Override
    public void check(PermissionChecker permissionChecker, Login model, String actionId) throws PortalException {

    }

    @Override
    public boolean contains(PermissionChecker permissionChecker, long primaryKey, String actionId) throws PortalException {
        return false;
    }

    @Override
    public boolean contains(PermissionChecker permissionChecker, Login model, String actionId) throws PortalException {
        return false;
    }

    @Override
    public String getModelName() {
        return null;
    }

    @Override
    public PortletResourcePermission getPortletResourcePermission() {
        return null;
    }
}
