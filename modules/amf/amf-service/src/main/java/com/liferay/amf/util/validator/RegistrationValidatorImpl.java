package com.liferay.amf.util.validator;

import com.liferay.amf.exception.RegistrationValidationExceptionException;
import com.liferay.amf.validator.RegistrationValidator;
import com.liferay.portal.kernel.util.Validator;

public class RegistrationValidatorImpl implements RegistrationValidator {
    @Override
    public void validate(String userName, String firstName, String lastName, String emailAddress) throws RegistrationValidationExceptionException {

        if(!Validator.isEmailAddress(emailAddress)){
            throw new RegistrationValidationExceptionException();
        }
        if (!isEntryValid(userName, firstName, lastName)){
            throw new RegistrationValidationExceptionException();
        }

    }
    private boolean isEntryValid(String userName, String firstName, String lastName){

        return Validator.isNotNull(userName) &&
                Validator.isNotNull(firstName) &&
                Validator.isNotNull(lastName);
    }
}
