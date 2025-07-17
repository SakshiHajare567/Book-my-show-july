package com.example.Book_My_Show_Application_July.Convertors;

import com.example.Book_My_Show_Application_July.Entites.MovieEntity;
import com.example.Book_My_Show_Application_July.EntryDtos.MovieEntryDto;

public class MovieConvertor {
    public static MovieEntity convertDtoTOEntity (MovieEntryDto movieEntryDto){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setMovieName(movieEntryDto.getMovieName());
        movieEntity.setGenre(movieEntryDto.getGenre());
        movieEntity.setDuration(movieEntryDto.getDuration());
        movieEntity.setRating(movieEntryDto.getRating());
        movieEntity.setLanguage(movieEntryDto.getLanguage());
        return movieEntity ;
    }
}
