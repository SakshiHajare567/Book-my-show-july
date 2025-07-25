package com.example.Book_My_Show_Application_July.Entites;

import com.example.Book_My_Show_Application_July.Enums.Genre;
import com.example.Book_My_Show_Application_July.Enums.Language;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="movies")
public class MovieEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(unique = true , nullable = false)
    private String movieName ;

    private double rating ;

    private  int duration ;

    @Enumerated(value = EnumType.STRING)
    private Genre genre; // movie type

    @Enumerated(value = EnumType.STRING)
    private Language language ;


    // parent :movieEntity connected to child:showEntity
    @OneToMany(mappedBy = "movieEntity",cascade = CascadeType.ALL)
    private List<ShowEntity>showEntityList=new ArrayList<>();

    public MovieEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<ShowEntity> getShowEntityList() {
        return showEntityList;
    }

    public void setShowEntityList(List<ShowEntity> showEntityList) {

        this.showEntityList = showEntityList;
    }

}
