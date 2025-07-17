package com.example.Book_My_Show_Application_July.Convertors;

import com.example.Book_My_Show_Application_July.Entites.TheaterEntity;
import com.example.Book_My_Show_Application_July.EntryDtos.TheaterEntryDto;

public class TheaterConvertor {
    public static TheaterEntity convertDtoToEntity (TheaterEntryDto theaterEntryDto){
        TheaterEntity theaterEntity = new TheaterEntity();
        theaterEntity.setName(theaterEntryDto.getName());
        theaterEntity.setLocation(theaterEntryDto.getLocation());
        return theaterEntity ;
    }
}
