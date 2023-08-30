package com.mycompany.controller;

import com.mycompany.dao.AdminDAO;
import com.mycompany.exception.AdminException;
import com.mycompany.pojo.Admin;
import com.mycompany.validator.AdminValidator;

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
public class AdminController {
	@Autowired
    private AdminValidator adminvalidator;
    
    @GetMapping("/admin/add.htm")
    public String addAdminGET(ModelMap model, Admin admin) throws Exception
    {
        model.addAttribute("admin", admin);
        return "admin-register";
    }
    
    @PostMapping("/admin/add.htm")
    public String addAdminPOST(@ModelAttribute("admin") Admin admin, BindingResult result, SessionStatus status) throws Exception
    {
        adminvalidator.validate(admin, result);
        
        if (result.hasErrors())
            return "admin-register";
        
        try {
        	AdminDAO adminDao = new AdminDAO();
        	adminDao.create(admin);
        }
        catch(AdminException e) {
        	System.out.println("Exception: " +e.getMessage());
        }
        
        status.setComplete();

        return "admin-reg-success";
    }
    
    @GetMapping("/admin/login.htm")
    public String loginAdminGET(ModelMap model, Admin logincheck) throws Exception
    {
        model.addAttribute("adminlogin", logincheck);
        return "admin-login";
    }
    
    @PostMapping("/admin/login.htm")
    public String loginAdminPOST(@ModelAttribute("adminlogin") Admin logincheck, BindingResult result, SessionStatus status) throws Exception
    {
        
        if (result.hasErrors())
            return "admin-login";
        
        try {
        	AdminDAO adminDao = new AdminDAO();
        	Admin a1 = adminDao.get(logincheck.getEmail());
        	if (a1 != null) {
        		if (a1.getPassword().equals(logincheck.getPassword())) {
        			return "menu";
        		} else {
        			return "invalid-admin";
        		}
        	} else {
        		return "invalid-admin";
        	}
        }
        catch(AdminException e) {
        	System.out.println("Exception: " +e.getMessage());
        }
        
        status.setComplete();

        return "menu";
    }
}
