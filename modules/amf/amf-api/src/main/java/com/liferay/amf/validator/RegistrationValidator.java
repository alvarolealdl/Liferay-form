package com.liferay.amf.validator;

import com.liferay.amf.exception.RegistrationValidationExceptionException;

import java.util.Date;


public interface RegistrationValidator {

    public void validate(String userName, String firstName, String lastName, String emailAddress) throws
            RegistrationValidationExceptionException;

    public void isValidBirthday(Date birthday) throws RegistrationValidationExceptionException;

}
