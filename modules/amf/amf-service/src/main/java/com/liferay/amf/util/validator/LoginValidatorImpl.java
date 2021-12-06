package com.liferay.amf.util.validator;

import com.liferay.amf.exception.LoginValidationExceptionException;
import com.liferay.amf.validator.LoginValidator;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;


@Component(
        immediate = true,
        service = LoginValidator.class
)
public class LoginValidatorImpl  implements LoginValidator{
    @Override
    public void validate(String emailAddress) throws LoginValidationExceptionException {


        if(!Validator.isEmailAddress(emailAddress)){
            throw new LoginValidationExceptionException();
        }

    }


}
