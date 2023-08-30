package com.mycompany.pojo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 *
 * @author kruthikak
 */

@Component
@Entity
@Table(name="movietable")
public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int movieID;   
    private String title;
    private String lang;
    
    @Transient
    private MultipartFile poster;

    public Movie() {
    }

    public Movie(String title, String lang) {
        this.title = title;
        this.lang = lang;
    }

    public MultipartFile getPoster() {
        return poster;
    }

    public void setPoster(MultipartFile poster) {
        this.poster = poster;
    }
    
    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
    
    
}
