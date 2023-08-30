package com.mycompany.controller;

import com.mycompany.dao.MovieDAO;
import com.mycompany.exception.MovieException;
import com.mycompany.pojo.Movie;
import com.mycompany.validator.MovieValidator;
import jakarta.servlet.http.HttpServletRequest;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class MovieController
{
	@Autowired
    MovieValidator movievalidator;
    
    @GetMapping("/admin/movie/add.htm")
    public String addMovieGET(ModelMap model,HttpServletRequest request, Movie movie ) throws Exception
    {
        model.addAttribute("movie", movie);
        return "add-movie";
    }
    
    @PostMapping("/admin/movie/add.htm")
    public String addMoviePOST(@ModelAttribute("movie") Movie movie, BindingResult result, SessionStatus status) throws Exception {
        movievalidator.validate(movie, result);
        
        if (result.hasErrors())
            return "add-movie";
        
        //save category to the database
         try {
        	 MovieDAO movieDao = new MovieDAO();
        	 movieDao.create(movie);
        	 String poster = movie.getTitle() + ".jpg";
        	 movie.getPoster().transferTo(new File("/Users/kruthikak/Desktop/NEU/MSIS/Sem-2/WebTools/Project/posters", poster));
         }
         catch(MovieException e) {
        	 System.out.println(e.getMessage());
        	
         }
        //mark it complete
        status.setComplete();
        
        return "add-movie-success";
    }
}
