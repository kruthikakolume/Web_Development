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
@Table(name="showstable")
public class Show {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int showID;
    private String movietitle;
    private int screen;
    private String time;
    private String postedBy;
    
    @ManyToOne
    @JoinColumn(name = "adminID", foreignKey = @ForeignKey(name = "fk_show_admin"))
    private Admin adminResponsible;

    public Show() {
    }

    public Show(int screen, String time, Admin adminResponsible) {
        this.screen = screen;
        this.time = time;
        this.adminResponsible = adminResponsible;
    }
    
    
    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
    
    public int getShowID() {
        return showID;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public Integer getScreen() {
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

    public Admin getAdminResponsible() {
        return adminResponsible;
    }

    public void setAdminResponsible(Admin adminResponsible) {
        this.adminResponsible = adminResponsible;
    }

    
    
    
}
