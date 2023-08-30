/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.validator;

/**
 *
 * @author kruthikak
 */

import com.mycompany.pojo.Movie;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

@Component
public class MovieValidator implements Validator {
	@Override
    public boolean supports(Class aClass)
    {
        return aClass.equals(Movie.class);
    }

	@Override
    public void validate(Object obj, Errors errors)
    {
        Movie movie = (Movie) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.movie", "Movie Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lang", "error.invalid.lang", "Language Required");

    }
}
