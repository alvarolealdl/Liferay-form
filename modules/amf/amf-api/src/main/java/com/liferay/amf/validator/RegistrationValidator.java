package com.liferay.amf.validator;
import com.liferay.amf.exception.RegistrationValidationExceptionException;


public interface RegistrationValidator {

    public void validate(String userName, String firstName, String lastName, String emailAddress) throws
            RegistrationValidationExceptionException;

}
