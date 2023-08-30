package com.mycompany.validator;

import com.mycompany.pojo.Admin;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

/**
 *
 * @author kruthikak
 */

@Component
public class AdminValidator implements Validator {
	
	@Override
    public boolean supports(Class aClass)
    {
        return aClass.equals(Admin.class);
    }

	@Override
    public void validate(Object obj, Errors errors)
    {
        Admin newAdmin = (Admin) obj;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "error.invalid.fname", "First name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "error.invalid.lname", "Last name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
    }
}
