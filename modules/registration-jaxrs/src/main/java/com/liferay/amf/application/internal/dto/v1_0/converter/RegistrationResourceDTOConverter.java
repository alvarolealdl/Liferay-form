package com.liferay.amf.application.internal.dto.v1_0.converter;

import com.liferay.amf.application.internal.dto.v1_0.RegistrationDTO;
import com.liferay.amf.model.Registration;
import com.liferay.amf.service.RegistrationLocalService;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        property = "dto.class.name=com.liferay.amf.model.Registration",
        service = {RegistrationResourceDTOConverter.class, DTOConverter.class}
)
public class RegistrationResourceDTOConverter implements DTOConverter<Registration, RegistrationDTO> {

    @Override
    public String getContentType() {
        return Registration.class.getSimpleName();
    }

    @Override
    public RegistrationDTO toDTO(Registration registration) throws Exception {
        return new RegistrationDTO(registration);
    }

    @Reference
    private RegistrationLocalService _registrationLocalService;
}
