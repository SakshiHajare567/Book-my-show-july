package com.example.Book_My_Show_Application_July.Service;

import com.example.Book_My_Show_Application_July.Convertors.TheaterConvertor;
import com.example.Book_My_Show_Application_July.Entites.TheaterEntity;
import com.example.Book_My_Show_Application_July.Entites.TheaterSeatEntity;
import com.example.Book_My_Show_Application_July.EntryDtos.TheaterEntryDto;
import com.example.Book_My_Show_Application_July.Enums.SeatType;
import com.example.Book_My_Show_Application_July.Repository.TheaterRepository;
import com.example.Book_My_Show_Application_July.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto) throws Exception {

        if (theaterEntryDto.getName() == null || theaterEntryDto.getLocation() == null) {
            throw new Exception("Theater Name and location are not required");
        }

        TheaterEntity theaterEntity = TheaterConvertor.convertDtoToEntity(theaterEntryDto);
        List<TheaterSeatEntity>theaterSeatEntityList=createTheaterSeats( theaterEntryDto , theaterEntity);
        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);
        theaterRepository.save(theaterEntity);

        return "Theater and Theater_seats added successfully!";

    }

    //created a new function
    private List<TheaterSeatEntity> createTheaterSeats( TheaterEntryDto theaterEntryDto,TheaterEntity theaterEntity) {
        int noOfClassicSeat = theaterEntryDto.getClassicSetsCount();
        int noOfPremiumSeat = theaterEntryDto.getPremiumSetsCount();

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();
           //created a classicSeat
        for(int count =1 ;count<=noOfClassicSeat ; count++){
            TheaterSeatEntity theaterSeatEntity = new TheaterSeatEntity();

            theaterSeatEntity.setSeatType(SeatType.CLASSIC);
            theaterSeatEntity.setSeatNo(count+"c");
            theaterSeatEntity.setTheaterEntity(theaterEntity);

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        //created primium seat

        for(int count =1 ; count<=noOfPremiumSeat; count++) {
            TheaterSeatEntity theaterSeatEntity = new TheaterSeatEntity();

            theaterSeatEntity.setSeatType(SeatType.PREMIUM);
            theaterSeatEntity.setSeatNo(count+"P");
            theaterSeatEntity.setTheaterEntity(theaterEntity);

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        return theaterSeatEntityList;


    }
}
git