package com.example.Book_My_Show_Application_July.Entites;

import com.example.Book_My_Show_Application_July.Enums.SeatType;
import jakarta.persistence.*;

@Entity
@Table(name="theater_seat")
public class TheaterSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private String seatNo ;

    //child "theater_seat connect to parent:theater
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private TheaterEntity theaterEntity ;

    public TheaterSeatEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public TheaterEntity getTheaterEntity() {
        return theaterEntity;
    }

    public void setTheaterEntity(TheaterEntity theaterEntity) {
        this.theaterEntity = theaterEntity;
    }

}
