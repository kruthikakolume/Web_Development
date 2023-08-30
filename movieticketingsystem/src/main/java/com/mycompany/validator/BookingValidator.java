package com.mycompany.validator;

import com.mycompany.pojo.Booking;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

/**
 *
 * @author kruthikak
 */

@Component
public class BookingValidator implements Validator {
	
	@Override
    public boolean supports(Class aClass)
    {
        return aClass.equals(Booking.class);
    }

	@Override
    public void validate(Object obj, Errors errors)
    {
		Booking newBooking = (Booking) obj;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfPpl", "error.invalid.numberOfPpl", "Number Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seatType", "error.invalid.seatType", "Seat Type Required");
    }
}
