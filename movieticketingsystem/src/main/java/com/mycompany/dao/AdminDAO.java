package com.mycompany.dao;

import com.mycompany.exception.AdminException;
import com.mycompany.exception.MovieException;
import com.mycompany.pojo.Admin;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

public class AdminDAO extends DAO {

    public AdminDAO() {
    }

    public Admin get(String adminEmail) throws AdminException {
    	 try {
            
         	begin();
         	Query q = getSession().createQuery("from Admin where email= :adminEmail");
         	q.setParameter("adminEmail", adminEmail);
         	Admin admin = (Admin) q.uniqueResult();
         
         	commit();
         	return admin;
         	
         } catch (HibernateException e) {
             rollback();
             throw new AdminException("Could not create admin " + adminEmail, e);
         }
    	
    }
    public Admin create(Admin admin) throws AdminException {
        try {
            //save admin object in the database
        	begin();
        	getSession().persist(admin);
        	commit();
        	close();
        	
        	return admin;
        } catch (HibernateException e) {
            rollback();
            throw new AdminException("Exception while creating admin: " + e.getMessage());
        }
    }

    public void delete(Admin admin) throws AdminException {
    	 try {
             //save admin object in the database
         	begin();
         	getSession().delete(admin);
         	commit();
         	
         } catch (HibernateException e) {
             rollback();
             throw new AdminException("Exception while deleting admin: " + e.getMessage());
         }
    }
    
    public List<String> list() throws MovieException {
        List<String> list1 = new ArrayList<>();
        try {
            begin();
        	Query query = getSession().createQuery("from Admin");
                List<Admin> list = query.list();
                for(Admin c: list){
                list1.add(c.getEmail());}
        	commit();
        	close();
        	
        	return list1;
        } catch (HibernateException e) {
            rollback();
            throw new MovieException("Exception while getting Movie: " + e.getMessage());
        }
    }
}