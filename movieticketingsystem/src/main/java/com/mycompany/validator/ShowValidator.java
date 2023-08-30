/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.validator;

import com.mycompany.pojo.Show;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

/**
 *
 * @author kruthikak
 */

@Component
public class ShowValidator implements Validator {
	@Override
    public boolean supports(Class aClass)
    {
        return aClass.equals(Show.class);
    }

	@Override
    public void validate(Object obj, Errors errors)
    {
        Show show = (Show) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "screen", "error.invalid.screen", "Screen Cannot be Empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "time", "error.invalid.time", "Time Cannot be Empty");        
        //additional validations could be done below
    }
}
