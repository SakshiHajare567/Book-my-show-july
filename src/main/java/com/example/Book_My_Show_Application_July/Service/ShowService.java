package com.example.Book_My_Show_Application_July.Service;


import com.example.Book_My_Show_Application_July.Convertors.ShowConvertor;
import com.example.Book_My_Show_Application_July.Entites.*;
import com.example.Book_My_Show_Application_July.EntryDtos.ShowEntryDto;
import com.example.Book_My_Show_Application_July.Enums.SeatType;
import com.example.Book_My_Show_Application_July.Repository.MovieRepository;
import com.example.Book_My_Show_Application_July.Repository.ShowRepository;
import com.example.Book_My_Show_Application_July.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    MovieRepository movieRepository ;

    @Autowired
    TheaterRepository theaterRepository ;

    @Autowired
    ShowRepository showRepository ;

    public String addShow (ShowEntryDto showEntryDto)throws Exception{


       /* ShowEntity showEntity = ShowConvertor.convertDtoToEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();
        int theaterId =showEntryDto.getTheaterId();

        // Get Movie and Theater entities safely
        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();


        // Set foreign key references
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        // Create and attach ShowSeatEntities
        List<ShowSeatEntity> seatEntityList = createShowSeatEntity(showEntryDto, showEntity);
        showEntity.setListOfShowSeats(seatEntityList);

        //set the parent
        List<ShowEntity>showEntityList=movieEntity.getShowEntityList();
        showEntityList.add(showEntity);
        movieEntity.setShowEntityList(showEntityList);
        movieRepository.save(movieEntity);

        List<ShowEntity>showEntityList1=theaterEntity.getShowEntityList();
        showEntityList1.add(showEntity);
        theaterEntity.setShowEntityList(showEntityList1);
        theaterRepository.save(theaterEntity);

        return "Show and show seats are added successfully.";*/

        // Convert DTO to Entity
        ShowEntity showEntity = ShowConvertor.convertDtoToEntity(showEntryDto);

        // Get movie and theater by ID
        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieId()).orElseThrow(() -> new Exception("Movie not found"));
        TheaterEntity theaterEntity = theaterRepository.findById(showEntryDto.getTheaterId()).orElseThrow(() -> new Exception("Theater not found"));

        // Set foreign keys
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        // Set bi-directional relationships (optional)
        movieEntity.getShowEntityList().add(showEntity);
        theaterEntity.getShowEntityList().add(showEntity);

        // Create and attach show seats
        List<ShowSeatEntity> showSeatEntities = createShowSeatEntity(showEntryDto, showEntity);
        showEntity.setListOfShowSeats(showSeatEntities);

        // ✅ Save only show (Hibernate will handle related entities)
        showRepository.save(showEntity);

        return "Show and show seats are added successfully.";
    }

    private List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto, ShowEntity showEntity) {
        TheaterEntity theaterEntity = showEntity.getTheaterEntity();

        List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntityList();

        List<ShowSeatEntity> seatEntityList = new ArrayList<>();

        for(TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());

            if(theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC))
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());

            else
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());


            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity); //parent : foreign key for the showSeat Entity

            seatEntityList.add(showSeatEntity); //Adding it to the list
        }

        return  seatEntityList;

    }
}



