package com.example.Book_My_Show_Application_July.Entites;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name="tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or AUTO
    private int id;

    private String movieName;

    private LocalDate showDate;

    private LocalTime showTime;

    private double totalAmount;

    private String ticketId= UUID.randomUUID().toString();

    private String theaterName;

    //private String bookedSeats;

    //child:ticket connect to parent"user
    @ManyToOne
    @JoinColumn
    private UserEntity userEntity ;

    //child:ticket Entity connect parent:show Entity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;


    public TicketEntity() {
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

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ShowEntity getShowEntity() {
        return showEntity;
    }

    public void setShowEntity(ShowEntity showEntity) {
        this.showEntity = showEntity;
    }
}
