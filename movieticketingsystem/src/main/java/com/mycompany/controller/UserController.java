package com.mycompany.controller;

import com.mycompany.dao.ShowDAO;
import com.mycompany.dao.UserDAO;
import com.mycompany.exception.UserException;
import com.mycompany.pojo.Show;
import com.mycompany.pojo.User;
import com.mycompany.validator.UserValidator;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import java.util.List;

/**
 *
 * @author kruthikak
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class UserController {
	@Autowired
    private UserValidator uservalidator;
    
    @GetMapping("/user/add.htm")
    public String addUserGET(ModelMap model, User user) throws Exception
    {
        model.addAttribute("user", user);
        return "user-register";
    }
    
    @PostMapping("/user/add.htm")
    public String addUserPOST(@ModelAttribute("user") User user, BindingResult result, SessionStatus status) throws Exception
    {
        uservalidator.validate(user, result);
        
        if (result.hasErrors())
            return "user-register";
        
        try {
        	UserDAO userDao = new UserDAO();
        	userDao.create(user);
        	Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(25);
            email.setAuthenticator(new DefaultAuthenticator("movieticketingsys@gmail.com", "zpfwyeiycezocpcm"));
            email.setSSLOnConnect(true);
            email.setFrom("movieticketingsys@gmail.com");
            email.setSubject("Registration Successful");
            email.setMsg("You have successfully registered with Movie Ticketing System.");
            email.addTo(user.getEmail());
            email.send();
        }
        catch(UserException e) {
        	System.out.println("Exception: " +e.getMessage());
        }
        
        status.setComplete();
        
        return "user-reg-success";
    }
    
    @GetMapping("/user/login.htm")
    public String loginUserGET(ModelMap model, User logincheck) throws Exception
    {
        model.addAttribute("userlogin", logincheck);
        return "user-login";
    }
    
    @PostMapping("/user/login.htm")
    public String loginUserPOST(@ModelAttribute("userlogin") User logincheck, ShowDAO showDAO, ModelMap model, BindingResult result, SessionStatus status) throws Exception
    {
        
        if (result.hasErrors())
            return "user-login";

        try {
        	UserDAO userDao = new UserDAO();
        	User a1 = userDao.get(logincheck.getEmail());
        	if (a1 != null) {
        		if (a1.getPassword().equals(logincheck.getPassword())) {
        			return "contents";
            	} else {
            		return "invalid-login";
            	}
        	} else {
        		return "invalid-login";
        	}
        }
        catch(UserException e) {
        	System.out.println("Exception: " +e.getMessage());
        }
        
        return "contents";
    }
    
    @GetMapping("/user/shows.htm")
    public String viewShowsGET(@ModelAttribute("userlogin") User logincheck, ShowDAO showDAO, ModelMap model, BindingResult result, SessionStatus status) throws Exception
    {
    	List<Show> list = showDAO.list();
        model.addAttribute("show", list);
    	
    	status.setComplete();
    	
        return "user-shows";
    }
}
