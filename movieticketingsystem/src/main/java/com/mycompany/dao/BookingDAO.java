package com.mycompany.dao;

import com.mycompany.exception.AdminException;
import com.mycompany.exception.BookingException;
import com.mycompany.pojo.Admin;
import com.mycompany.pojo.Booking;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author kruthikak
 */
public class BookingDAO extends DAO {

	public void create(Booking booking) throws BookingException {
		try {
			begin();
			getSession().persist(booking);
			commit();
			close();

			// save Booking to the database
		} catch (HibernateException e) {
			rollback();
			// throw new BookingException("Could not create Booking", e);
			throw new BookingException("Exception while creating Booking: " + e.getMessage());
		}
	}

	public Booking get(int bookingID) throws BookingException {
		try {

			begin();
			Query q = getSession().createQuery("from Booking where bookingID= :bookingID");
			q.setParameter("bookingID", bookingID);
			Booking booking = (Booking) q.uniqueResult();

			commit();
			return booking;

		} catch (HibernateException e) {
			rollback();
			throw new BookingException("Could not get booking " + bookingID, e);
		}

	}

	public void update(Booking booking) throws BookingException {
		try {
			begin();
			getSession().merge(booking);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new BookingException("Exception while updating booking: " + e.getMessage());
		}
	}

	public void delete(Booking booking) throws BookingException {
		try {
			begin();
			getSession().remove(booking);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new BookingException("Exception while deleting booking: " + e.getMessage());
		}
	}

	public List<Booking> list() throws BookingException {
		try {
			begin();
			Query query = getSession().createQuery("from Booking");
			List<Booking> list = query.list();
			commit();
			close();

			return list;
			// save Booking to the database
		} catch (HibernateException e) {
			rollback();
			// throw new BookingException("Could not create booking", e);
			throw new BookingException("Exception while creating Booking: " + e.getMessage());
		}
	}

}
