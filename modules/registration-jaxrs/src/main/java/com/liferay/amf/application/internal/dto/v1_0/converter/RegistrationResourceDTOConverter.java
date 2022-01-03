package com.liferay.amf.application.internal.dto.v1_0.converter;

import com.liferay.amf.application.internal.dto.v1_0.RegistrationDTO;
import com.liferay.amf.model.Registration;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import org.osgi.service.component.annotations.Component;

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
    public RegistrationDTO toDTO(Registration registration)  {
        return new RegistrationDTO(registration);
    }

}
