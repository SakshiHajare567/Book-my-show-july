package com.example.Book_My_Show_Application_July.EntryDtos;

import com.example.Book_My_Show_Application_July.Enums.ShowType;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowEntryDto {
    private LocalTime localTime;
    private LocalDate localDate;
    private ShowType showType;
    private int classicSeatPrice;
    private int premiumSeatPrice;
    private int movieId ;
    private int theaterId ;

    public ShowEntryDto() {
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public ShowType getShowType() {
        return showType;
    }

    public void setShowType(ShowType showType) {
        this.showType = showType;
    }

    public int getClassicSeatPrice() {
        return classicSeatPrice;
    }

    public void setClassicSeatPrice(int classicSeatPrice) {
        this.classicSeatPrice = classicSeatPrice;
    }

    public int getPremiumSeatPrice() {
        return premiumSeatPrice;
    }

    public void setPremiumSeatPrice(int premiumSeatPrice) {
        this.premiumSeatPrice = premiumSeatPrice;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }
}
