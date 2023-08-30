package com.mycompany.dao;

import com.mycompany.exception.UserException;
import com.mycompany.pojo.Admin;
import com.mycompany.pojo.User;
import com.mycompany.exception.MovieException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

public class UserDAO extends DAO {

    public UserDAO() {
    }

    public User get(String userEmail) throws UserException {
    	 try {
            
         	begin();
         	Query q = getSession().createQuery("from User where email= :userEmail");
         	q.setParameter("userEmail", userEmail);
         	User user = (User) q.uniqueResult();
         
         	commit();
         	return user;
         	
         } catch (HibernateException e) {
             rollback();
             throw new UserException("Could not create user " + userEmail, e);
         }
    	
    }
    public User create(User user) throws UserException {
        try {
            //save user object in the database
        	begin();
        	getSession().persist(user);
        	commit();
        	close();
        	
        	return user;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(User user) throws UserException {
    	 try {
             //save user object in the database
         	begin();
         	getSession().delete(user);
         	commit();
         	
         } catch (HibernateException e) {
             rollback();
             throw new UserException("Exception while deleting user: " + e.getMessage());
         }
    }
    
    public List<String> list() throws UserException {
        List<String> list1 = new ArrayList<>();
        try {
            begin();
        	Query query = getSession().createQuery("from User");
                List<User> list = query.list();
                for(User c: list){
                list1.add(c.getEmail());}
        	commit();
        	close();
        	
        	return list1;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Exception while getting user: " + e.getMessage());
        }
    }
}