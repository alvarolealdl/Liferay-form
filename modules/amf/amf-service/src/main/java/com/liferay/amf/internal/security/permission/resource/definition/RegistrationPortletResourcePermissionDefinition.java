package com.liferay.amf.internal.security.permission.resource.definition;


import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = PortletResourcePermissionDefinition.class
)
public class RegistrationPortletResourcePermissionDefinition implements PortletResourcePermissionDefinition{

    @Override
    public PortletResourcePermissionLogic[] getPortletResourcePermissionLogics() {
        return new PortletResourcePermissionLogic[]{
                new StagedPortletPermissionLogic(
                        _stagingPermission,
                        "com_liferay_amf_web_RegistrationPortlet"

                )

        };
    }

    @Override
    public String getResourceName() {
        return "com.liferay.amf";
    }

    @Reference
    private StagingPermission _stagingPermission;
}
