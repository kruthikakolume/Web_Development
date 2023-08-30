package com.mycompany.controller;

import com.mycompany.dao.AdminDAO;
import com.mycompany.dao.MovieDAO;
import com.mycompany.dao.ShowDAO;
import com.mycompany.exception.MovieException;
import com.mycompany.exception.ShowException;
import com.mycompany.pojo.Admin;
import com.mycompany.pojo.Show;
import com.mycompany.validator.ShowValidator;
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
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author kruthikak
 */

@Controller
public class ShowController {
	@Autowired
    ShowValidator showvalidator;

    @GetMapping("/admin/show/add.htm")
    public String addShowGET(ModelMap model,HttpServletRequest request,AdminDAO adminDAO, Show show, ShowDAO showDAO, MovieDAO movieDAO) throws ShowException, MovieException {
        
        List<String> movieList = movieDAO.list();
        List<String> adminList = adminDAO.list();
        request.setAttribute("movieList", movieList);
        request.setAttribute("adminList", adminList);
        model.addAttribute("show", show);
        return "add-show";
    }

    @PostMapping("/admin/show/add.htm")
    public String addShowPOST(HttpServletRequest request, @ModelAttribute("show") Show show, BindingResult result, SessionStatus status, 
            ShowDAO showDAO, AdminDAO adminDao, MovieDAO movieDao) throws Exception {
            
        showvalidator.validate(show, result);

        if (result.hasErrors()) {
            return "add-show";
        }
        

        Admin adminResp = adminDao.get(show.getPostedBy());
        show.setAdminResponsible(adminResp);
      
        show.setMovietitle(show.getMovietitle());
        showDAO.create(show);
        
        status.setComplete();
        request.setAttribute("movietitle", show.getMovietitle());
        request.setAttribute("screen", show.getScreen());
        request.setAttribute("time", show.getTime());
        return "add-show-success";
    }

    @GetMapping("/admin/show/view.htm")
    public String viewShowGET(ModelMap model, Show show, ShowDAO showDAO, HttpServletRequest request) throws ShowException {
        List<Show> list = showDAO.list();
        model.addAttribute("show", list);
        return "view-shows";
    }
    
    @GetMapping("/admin/show/update/id={showID}")
	public String updateShowForm(@PathVariable int showID, ShowDAO showDAO, ModelMap model) throws ShowException {
		Show updateshow = showDAO.get(showID);
		model.addAttribute("updateshow", updateshow);
		return "update-show";
	}

	@PostMapping("/admin/show/update/id={showID}")
	public String updateShow(@PathVariable int showID, @ModelAttribute("updateshow") Show updateshow,
			BindingResult bindingResult, ShowDAO showDAO, ModelMap model) throws ShowException {

		if (bindingResult.hasErrors()) {
			model.addAttribute("updateshow", updateshow);
			return "update-show";
		}

		showDAO.update(updateshow);

		return "redirect:/admin/show/view.htm";
	}
    
    @GetMapping("/admin/show/delete/id={showID}")
	public String deleteShow(@PathVariable int showID, ShowDAO showDAO) throws ShowException {
		Show existingShow = showDAO.get(showID);
		showDAO.delete(existingShow);

		return "redirect:/admin/show/view.htm";
	}
}
