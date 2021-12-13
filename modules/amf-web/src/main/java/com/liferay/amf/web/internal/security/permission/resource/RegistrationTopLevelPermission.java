package com.liferay.amf.web.internal.security.permission.resource;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true
)
public class RegistrationTopLevelPermission {

    public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){

        return _portletResourcePermission.contains(permissionChecker, groupId, actionId);
    }

    @Reference(
            target = "(resource.name= com_liferay_amf_web_RegistrationPortlet)",
            unbind = "-"
    )
    protected void setPortletResourcePermission(
            PortletResourcePermission portletResourcePermission) {
        _portletResourcePermission = portletResourcePermission;
    }

    private static PortletResourcePermission _portletResourcePermission;
}
