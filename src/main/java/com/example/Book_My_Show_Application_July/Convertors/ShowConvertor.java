package com.example.Book_My_Show_Application_July.Convertors;

import com.example.Book_My_Show_Application_July.Entites.ShowEntity;
import com.example.Book_My_Show_Application_July.EntryDtos.ShowEntryDto;

public class ShowConvertor {
    public static ShowEntity convertDtoToEntity (ShowEntryDto showEntryDto){
        ShowEntity showEntity = new ShowEntity();
        showEntity.setShowDate(showEntryDto.getLocalDate());
        showEntity.setShowTime(showEntryDto.getLocalTime());
        showEntity.setShowType(showEntryDto.getShowType());

        return showEntity ;

    }
}