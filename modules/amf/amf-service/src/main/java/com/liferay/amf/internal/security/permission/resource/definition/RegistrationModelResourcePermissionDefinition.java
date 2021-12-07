package com.liferay.amf.internal.security.permission.resource.definition;

import com.liferay.amf.model.Registration;
import com.liferay.amf.service.RegistrationLocalService;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.function.Consumer;


@Component(
        immediate = true,
        service = ModelResourcePermissionDefinition.class
)
public class RegistrationModelResourcePermissionDefinition implements ModelResourcePermissionDefinition<Registration> {
    @Override
    public Registration getModel(long primaryKey) throws PortalException {
        return _registrationLocalService.getRegistration(primaryKey);
    }

    @Override
    public Class<Registration> getModelClass() {
        return Registration.class;
    }

    @Override
    public PortletResourcePermission getPortletResourcePermission() {
        return _portletResourcePermission;
    }

    @Override
    public long getPrimaryKey(Registration registration) {
        return registration.getAmfRegistrationId();
    }

    @Override
    public void registerModelResourcePermissionLogics(ModelResourcePermission<Registration> modelResourcePermission,
                                                      Consumer<ModelResourcePermissionLogic<Registration>>
                                                              modelResourcePermissionLogicConsumer) {

            modelResourcePermissionLogicConsumer.accept(
                    new StagedModelPermissionLogic<>(
                            _stagingPermission,
                            "com_liferay_amf_web_RegistrationPortlet",
                            Registration :: getAmfRegistrationId
                    )
            );
    }

    @Reference
    private RegistrationLocalService _registrationLocalService;

    @Reference(
            target = "com.liferay.amf.web.RegistrationPortlet"
    )
    private PortletResourcePermission _portletResourcePermission;

    @Reference
    private StagingPermission _stagingPermission;
}
