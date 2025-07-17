package com.example.Book_My_Show_Application_July.Service;

import com.example.Book_My_Show_Application_July.Convertors.MovieConvertor;
import com.example.Book_My_Show_Application_July.Entites.MovieEntity;
import com.example.Book_My_Show_Application_July.EntryDtos.MovieEntryDto;
import com.example.Book_My_Show_Application_July.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository ;

    public String addMovie (MovieEntryDto movieEntryDto)throws Exception{
        MovieEntity movieEntity = MovieConvertor.convertDtoTOEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "Movie added successfully";

    }
}
