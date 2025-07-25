package com.example.Book_My_Show_Application_July.Controller;
import com.example.Book_My_Show_Application_July.EntryDtos.TicketEntryDto;
import com.example.Book_My_Show_Application_July.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Tickets")
public class TicketController {
    @Autowired
    TicketService ticketService ;

    @PostMapping("/addTicket")
    public ResponseEntity<String> addTicket (@RequestBody TicketEntryDto ticketEntryDto){
        try{
            String result = ticketService.addTicket(ticketEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);

        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
