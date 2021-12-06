package com.liferay.amf.validator;

import com.liferay.amf.exception.LoginValidationExceptionException;


public interface LoginValidator {

    public void validate(String emailAddress) throws
            LoginValidationExceptionException;

}
