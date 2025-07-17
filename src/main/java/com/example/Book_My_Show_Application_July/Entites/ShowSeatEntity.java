package com.example.Book_My_Show_Application_July.Entites;

import com.example.Book_My_Show_Application_July.Enums.SeatType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="show_Seats")
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;

    private boolean isbooked ;
    private  int price ;
    private String seatNo ;
    private Date bookedAt ;//time of seatbook

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    //chid :show_seat Entity connect to parent:show Entity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity ;

    public ShowSeatEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsbooked() {
        return isbooked;
    }

    public void setIsbooked(boolean isbooked) {
        this.isbooked = isbooked;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Date getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        this.bookedAt = bookedAt;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public ShowEntity getShowEntity() {
        return showEntity;
    }

    public void setShowEntity(ShowEntity showEntity) {
        this.showEntity = showEntity;
    }
}
