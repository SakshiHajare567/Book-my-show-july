package com.example.Book_My_Show_Application_July.Entites;

import com.example.Book_My_Show_Application_July.Enums.ShowType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="shows")
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private LocalTime showTime ;

    private LocalDate showDate ;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType ;


    @CreationTimestamp
    @Column(name = "created_on", updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on")
    private Date updatedOn;

    //child:show connect to the parent:movie
    @ManyToOne
    @JoinColumn
    MovieEntity movieEntity ;

    //child:show entity connect to therater entity
    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity ;

    //parent :show Entity connect Child:ticket
    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)  // ✅ correct field name
    private List<TicketEntity> listOfBookedTicket = new ArrayList<>();


    //parent:show Entity connect to child : show_seat Entity
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<ShowSeatEntity>listOfShowSeats=new ArrayList<>();




    public ShowEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public ShowType getShowType() {
        return showType;
    }

    public void setShowType(ShowType showType) {
        this.showType = showType;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public MovieEntity getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(MovieEntity movieEntity) {

        this.movieEntity = movieEntity;
    }

    public TheaterEntity getTheaterEntity() {
        return theaterEntity;
    }

    public void setTheaterEntity(TheaterEntity theaterEntity) {
        this.theaterEntity = theaterEntity;
    }

    public List<TicketEntity> getListOfBookedTicket() {
        return listOfBookedTicket;
    }

    public void setListOfBookedTicket(List<TicketEntity> listOfBookedTicket) {
        this.listOfBookedTicket = listOfBookedTicket;
    }

    public List<ShowSeatEntity> getListOfShowSeats() {
        return listOfShowSeats;
    }

    public void setListOfShowSeats(List<ShowSeatEntity> listOfShowSeats) {
        this.listOfShowSeats = listOfShowSeats;
    }
}

