package com.liferay.amf.util.validator;

import com.liferay.amf.exception.RegistrationValidationExceptionException;
import com.liferay.amf.validator.RegistrationValidator;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import java.util.Calendar;
import java.util.Date;

@Component(
        immediate = true,
        service = RegistrationValidator.class
)
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

    @Override
    public void isValidBirthday(Date birthday) throws RegistrationValidationExceptionException {

        Calendar birthdayCalendar = Calendar.getInstance();
        birthdayCalendar.setTime(birthday);
        Calendar rightNow = Calendar.getInstance();

        if((rightNow.get(Calendar.YEAR) - birthdayCalendar.get(Calendar.YEAR)) < 13){
            throw new RegistrationValidationExceptionException("Birthday must be at least 13.");
        }
    }

    private boolean isEntryValid(String userName, String firstName, String lastName){

        return Validator.isNotNull(userName) &&
                Validator.isNotNull(firstName) &&
                Validator.isNotNull(lastName);
    }
}
