package com.example.Book_My_Show_Application_July.Controller;

import com.example.Book_My_Show_Application_July.EntryDtos.ShowEntryDto;
import com.example.Book_My_Show_Application_July.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto) {
        try {
            String result = showService.addShow(showEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            String response = "Show could not added";
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
    }
}

