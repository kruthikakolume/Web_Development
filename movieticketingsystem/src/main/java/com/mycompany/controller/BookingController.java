package com.mycompany.controller;

import com.mycompany.dao.ShowDAO;
import com.mycompany.dao.BookingDAO;
import com.mycompany.dao.UserDAO;
import com.mycompany.exception.BookingException;
import com.mycompany.exception.ShowException;
import com.mycompany.exception.UserException;
import com.mycompany.pojo.Booking;
import com.mycompany.pojo.Show;
import com.mycompany.pojo.User;
import com.mycompany.validator.BookingValidator;
import java.util.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kruthikak
 */

@Controller
public class BookingController {
	@Autowired
    BookingValidator bookingvalidator;
	
	@GetMapping("/user/bookShow/id={showID}")
    public String viewBookShowGET(@PathVariable int showID, HttpServletRequest request, UserDAO userDAO, ShowDAO showDAO, ModelMap model, Booking booking) throws ShowException, UserException {
    	List<String> userList = userDAO.list();
        request.setAttribute("userList", userList);
    	Map<String, String> seatTypes = new LinkedHashMap<String, String>();
    	seatTypes.put("P", "Platinum");
    	seatTypes.put("G", "Gold");
    	seatTypes.put("S", "Silver");
    	request.setAttribute("seatTypes", seatTypes);
    	Show show = showDAO.get(showID);
    	request.setAttribute("movietitle", show.getMovietitle());
    	request.setAttribute("screen", show.getScreen());
    	request.setAttribute("time", show.getTime());
    	model.addAttribute("bookShow", booking);
        return "booking";
    }
    
    @PostMapping("/user/bookShow/id={showID}")
	public String viewBookShowPOST(@PathVariable int showID, @ModelAttribute("bookShow") Show updateshow,
			BindingResult bindingResult, User user, ShowDAO showDAO, UserDAO userDao, HttpServletRequest request, ModelMap model, Booking bookShow) throws ShowException, UserException {

		if (bindingResult.hasErrors()) {
			return "booking";
		}

		try {
			Show show = showDAO.get(showID);
	      
	        bookShow.setMovietitle(show.getMovietitle());
	        bookShow.setScreen(show.getScreen());
	        bookShow.setTime(show.getTime());
	        
	        User userPosted = userDao.get(bookShow.getBookedBy());
	        bookShow.setUserBooked(userPosted);
	        
	        String type = bookShow.getSeatType();
	        int num = bookShow.getNumberOfPpl();
	        int price = 0;
	        
	        if (type.equals("P")) {
	        	price = num * 25;
	        } else  if (type.equals("G")) {
	        	price = num * 20;
	        } else {
	        	price = num * 15;
	        }
	        
	        bookShow.setPrice(price);
	        
	        BookingDAO bookingDao = new BookingDAO();
        	bookingDao.create(bookShow);
        	
        	request.setAttribute("username", userPosted.getFname());
        	request.setAttribute("movietitle", bookShow.getMovietitle());
        	request.setAttribute("screen", bookShow.getScreen());
        	request.setAttribute("time", bookShow.getTime());
        	request.setAttribute("num", num);
        	request.setAttribute("type", type);
        	request.setAttribute("price", price);
        }
        catch(BookingException e) {
        	System.out.println("Exception: " +e.getMessage());
        }
		
		return "booking-confirmation";
	}
    
    @GetMapping("/user/bookShow/payment.htm")
    public String addAdminGET(ModelMap model) throws Exception
    {
        return "payment";
    }
    
    @GetMapping("/user/bookShow/viewBooking.htm")
    public String viewShowGET(ModelMap model, Booking booking, BookingDAO bookingDAO) throws BookingException {
        List<Booking> list = bookingDAO.list();
        model.addAttribute("booking", list);
        return "view-booking";
    }
    
    @GetMapping("/user/bookShow/delete/id={bookingID}")
	public String deleteShow(@PathVariable int bookingID, BookingDAO bookingDAO) throws BookingException {
		Booking booking = bookingDAO.get(bookingID);
		bookingDAO.delete(booking);

		return "redirect:/user/bookShow/viewBooking.htm";
	}
    
}