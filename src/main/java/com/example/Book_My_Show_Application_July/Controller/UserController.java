package com.example.Book_My_Show_Application_July.Controller;

import com.example.Book_My_Show_Application_July.EntryDtos.UserEntryDto;
import com.example.Book_My_Show_Application_July.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService ;

    @PostMapping("/addUser")
    public ResponseEntity <String> addUser (@RequestBody UserEntryDto userEntryDto){

        try{
            String response = userService.addUser(userEntryDto);
            return  new ResponseEntity<>(response , HttpStatus.CREATED);
        }
        catch (Exception e){
            String result = "User could not added";
            return  new ResponseEntity<>(result , HttpStatus.BAD_REQUEST);
        }
    }
}
