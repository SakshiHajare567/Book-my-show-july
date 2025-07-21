package com.example.Book_My_Show_Application_July.Service;

import com.example.Book_My_Show_Application_July.Convertors.TicketConvertor;
import com.example.Book_My_Show_Application_July.Entites.ShowEntity;
import com.example.Book_My_Show_Application_July.Entites.ShowSeatEntity;
import com.example.Book_My_Show_Application_July.Entites.TicketEntity;
import com.example.Book_My_Show_Application_July.Entites.UserEntity;
import com.example.Book_My_Show_Application_July.EntryDtos.TicketEntryDto;
import com.example.Book_My_Show_Application_July.Repository.ShowRepository;
import com.example.Book_My_Show_Application_July.Repository.TicketRepository;
import com.example.Book_My_Show_Application_July.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository ;

    @Autowired
    ShowRepository  showRepository ;

    @Autowired
    UserRepository userRepository ;


    public String addTicket (TicketEntryDto ticketEntryDto)throws Exception {
       /* TicketEntity ticketEntity = TicketConvertor.convertDtoToEntity(ticketEntryDto);

        //validation:check requested seat available are not?
        boolean isValidRequest = checkValidityOfRequestedSeats(ticketEntryDto);
        if (!isValidRequest) {
            throw new Exception("requested seat are not available");
        }

        //calculate the total amount of ticket price?
        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();
        List<ShowSeatEntity> seatEntityList = showEntity.getListOfShowSeats();
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

        int totalAmount = 0;
        for (ShowSeatEntity showSeatEntity : seatEntityList) {
            if (requestedSeats.contains(showSeatEntity.getSeatNo())) {
                totalAmount = totalAmount + showSeatEntity.getPrice();
                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedAt(new Date());
            }
        }
        ticketEntity.setTotalAmount(totalAmount);

        //set the foreing key  and other attributed
        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());

        //We need to set that string that talked about requested Seats
        String allottedSeats = getAllottedSeatsAsString (requestedSeats);
        ticketEntity.setBookedSeats(allottedSeats);

        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId()).get();
        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        // Save ticket
        ticketRepository.save(ticketEntity);

        //save parent
        List<TicketEntity> ticketEntityList = showEntity.getListOfBookedTicket();
        ticketEntityList.add(ticketEntity);
        showEntity.setListOfBookedTicket(ticketEntityList);

        showRepository.save(showEntity);


        List<TicketEntity> ticketEntityList1 = userEntity.getBookedTickets();
        ticketEntityList1.add(ticketEntity);
        userEntity.setBookedTickets(ticketEntityList1);

        userRepository.save(userEntity);

        return "Ticket has been booked successfully";



    }

    /*private String getAllottedSeatsAsString (List<String> requestedSeats){
        String result = "";
        for(String seat :requestedSeats){
            result= result + seat +",";
        }
        return result ;
    }*/

   // private String getAllottedSeatsAsString(List<String> requestedSeats) {
     //   return String.join(",", requestedSeats);
  //  }


    //:check requested seat available are not?
   /* private boolean checkValidityOfRequestedSeats(TicketEntryDto ticketEntryDto){
        int showId = ticketEntryDto.getShowId();
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

        // Get the show
        ShowEntity showEntity = showRepository.findById(showId).get();

        // Get all show seats
        List<ShowSeatEntity> listOfSeats = showEntity.getListOfShowSeats();

        // Check if any requested seat is already booked
        for (ShowSeatEntity seat : listOfSeats) {
            if (requestedSeats.contains(seat.getSeatNo())) {
                if (seat.isBooked()) {
                    return false; // If even one seat is booked, not valid
                }
            }
        }

        return true; // All requested seats are available

    }



    }*/

        // Safely fetch ShowEntity
        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId())
                .orElseThrow(() -> new Exception("Show not found with ID: " + ticketEntryDto.getShowId()));

        // Safely fetch UserEntity
        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId())
                .orElseThrow(() -> new Exception("User not found with ID: " + ticketEntryDto.getUserId()));

        // Validate requested seats
        if (!checkValidityOfRequestedSeats(ticketEntryDto, showEntity)) {
            throw new Exception("Requested seats are not available");
        }

        // Convert DTO to Entity
        TicketEntity ticketEntity = TicketConvertor.convertDtoToEntity(ticketEntryDto);

        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();
        List<ShowSeatEntity> seatEntityList = showEntity.getListOfShowSeats();

        // Calculate total amount and mark seats booked
        int totalAmount = 0;
        for (ShowSeatEntity seat : seatEntityList) {
            if (requestedSeats.contains(seat.getSeatNo())) {
                totalAmount += seat.getPrice();
                seat.setBooked(true);
                seat.setBookedAt(new Date());
            }
        }

        // Set ticket details
        ticketEntity.setTotalAmount(totalAmount);
        ticketEntity.setBookedSeats(getAllottedSeatsAsString(requestedSeats));
        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        // Save ticket
        ticketRepository.save(ticketEntity);

        // Add ticket to show
        showEntity.getListOfBookedTicket().add(ticketEntity);
        showRepository.save(showEntity);

        // Add ticket to user
        userEntity.getBookedTickets().add(ticketEntity);
        userRepository.save(userEntity);

        return "Ticket has been booked successfully";
    }

    private String getAllottedSeatsAsString(List<String> requestedSeats) {
        return String.join(",", requestedSeats);
    }

    private boolean checkValidityOfRequestedSeats(TicketEntryDto ticketEntryDto, ShowEntity showEntity) {
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();
        List<ShowSeatEntity> listOfSeats = showEntity.getListOfShowSeats();

        for (ShowSeatEntity seat : listOfSeats) {
            if (requestedSeats.contains(seat.getSeatNo()) && seat.isBooked()) {
                return false;
            }
        }

        return true;
    }
}

