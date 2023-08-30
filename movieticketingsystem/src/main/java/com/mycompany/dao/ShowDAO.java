/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.exception.AdminException;
import com.mycompany.exception.ShowException;
import com.mycompany.pojo.Admin;
import com.mycompany.pojo.Show;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author kruthikak
 */
public class ShowDAO extends DAO {

	public void create(Show show) throws ShowException {
		try {
			begin();
			getSession().persist(show);
			commit();
			close();

			// save Show to the database
		} catch (HibernateException e) {
			rollback();
			// throw new ShowException("Could not create Show", e);
			throw new ShowException("Exception while creating Show: " + e.getMessage());
		}
	}

	public Show get(int showID) throws ShowException {
		try {

			begin();
			Query q = getSession().createQuery("from Show where showID= :showID");
			q.setParameter("showID", showID);
			Show show = (Show) q.uniqueResult();

			commit();
			return show;

		} catch (HibernateException e) {
			rollback();
			throw new ShowException("Could not get show " + showID, e);
		}

	}

	public void update(Show show) throws ShowException {
		try {
			begin();
			getSession().merge(show);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new ShowException("Exception while updating show: " + e.getMessage());
		}
	}

	public void delete(Show show) throws ShowException {
		try {
			begin();
			getSession().remove(show);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new ShowException("Exception while deleting show: " + e.getMessage());
		}
	}

	public List<Show> list() throws ShowException {
		try {
			begin();
			Query query = getSession().createQuery("from Show");
			List<Show> list = query.list();
			commit();
			close();

			return list;
			// save Show to the database
		} catch (HibernateException e) {
			rollback();
			// throw new ShowException("Could not create show", e);
			throw new ShowException("Exception while creating Show: " + e.getMessage());
		}
	}

}
