package com.mycompany.pojo;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;

/**
 *
 * @author kruthikak
 */

@Component
@Entity
@Table(name="bookingstable")
public class Booking {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int bookingID;
    private String movietitle;
    private int screen;
    private String time;
    private String bookedBy;
    private int numberOfPpl;
    private String seatType;
    private int price;
    
    @ManyToOne
    @JoinColumn(name = "userID", foreignKey = @ForeignKey(name = "fk_booking_user"))
    private User userBooked;

    public Booking() {
    }

    public Booking(int screen, String time, String seatType, int numberOfPpl, User userBooked) {
        this.screen = screen;
        this.time = time;
        this.numberOfPpl = numberOfPpl;
        this.seatType = seatType;
        this.userBooked = userBooked;
    }
    
    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public int getNumberOfPpl() {
        return numberOfPpl;
    }

    public void setNumberOfPpl(int numberOfPpl) {
        this.numberOfPpl = numberOfPpl;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public User getUserBooked() {
        return userBooked;
    }

    public void setUserBooked(User userBooked) {
        this.userBooked = userBooked;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
