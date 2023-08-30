/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.exception.MovieException;
import com.mycompany.pojo.Movie;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
/**
 *
 * @author kruthikak
 */

public class MovieDAO extends DAO {
	
	public Movie get(String title) throws MovieException {
		
		 try {
	            //save Movie to the database
	        	
	        	begin();
	        	Query q = getSession().createQuery("from Movie where title = :title ");
	        	q.setParameter("title", title);
	        	Movie movie =(Movie) q.uniqueResult();
	        	commit();
	        	
	        	return movie;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create the Movie", e);
	            throw new MovieException("Exception while obtaining the name from the database: " + title + " " +e.getMessage());
	        }
	}
	
    public Movie create(Movie movie) throws MovieException {
       try{
           begin();
           getSession().save(movie);
           commit();
           close();
           
           return null;
       }catch(HibernateException e){
           rollback();
           throw new MovieException("Exception while creating the movie"+ e.getMessage());
       }
    }
    
    public void save(Movie movie) throws MovieException {
        try{
            begin();
            getSession().update(movie);
            commit();
            close();
        }catch(HibernateException e){
           rollback();
           throw new MovieException("Exception while updating the movie"+ e.getMessage());
       }
    }
    
    
    public void delete(Movie movie) throws MovieException {
        
        try{
            begin();
            getSession().delete(movie);
            commit();
            close();
        }catch(HibernateException e){
            throw new MovieException("Exception while deleting the movie");
        }
        
    }
    
    public List<String> list() throws MovieException {
        List<String> list1 = new ArrayList<>();
        try {
            begin();
        	Query query = getSession().createQuery("from Movie");
                List<Movie> list = query.list();
                for(Movie c: list){
                list1.add(c.getTitle());}
        	commit();
        	close();
        	
        	return list1;
            //save advertisement to the database
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create movie", e);
            throw new MovieException("Exception while getting Movie: " + e.getMessage());
        }
    }
}