package com.example.Book_My_Show_Application_July.Service;
import com.example.Book_My_Show_Application_July.Convertors.UserConvertor;
import com.example.Book_My_Show_Application_July.Entites.UserEntity;
import com.example.Book_My_Show_Application_July.EntryDtos.UserEntryDto;
import com.example.Book_My_Show_Application_July.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto) throws  Exception{
        UserEntity userEntity = UserConvertor.convertDtoToEntity (userEntryDto);
        userRepository.save(userEntity);
        return "User added successfully";
    }
}
