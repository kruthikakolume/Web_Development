package com.mycompany.movieticketingsystem.util;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import com.mycompany.pojo.Admin;
import com.mycompany.pojo.Movie;
import com.mycompany.pojo.Show;
import com.mycompany.pojo.User;
import com.mycompany.pojo.Booking;


@Component
public class HibernateUtil {
	
	  private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	                Configuration configuration = new Configuration();

	                // Hibernate settings equivalent to hibernate.cfg.xml's properties
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/movieticketingsys?createDatabaseIfNotExist=true");
	                settings.put(Environment.USER, "root");
	                settings.put(Environment.PASS, "password");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

	                settings.put(Environment.SHOW_SQL, "true");

	                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	                settings.put(Environment.HBM2DDL_AUTO, "create");

	                configuration.setProperties(settings);

	                configuration.addAnnotatedClass(Admin.class);
	                configuration.addAnnotatedClass(Movie.class);
	                configuration.addAnnotatedClass(Show.class);
	                configuration.addAnnotatedClass(User.class);
	                configuration.addAnnotatedClass(Booking.class);

	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();

	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }
}
