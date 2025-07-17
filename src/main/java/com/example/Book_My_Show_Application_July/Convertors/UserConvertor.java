package com.example.Book_My_Show_Application_July.Convertors;

import com.example.Book_My_Show_Application_July.Entites.UserEntity;
import com.example.Book_My_Show_Application_July.EntryDtos.UserEntryDto;

public class UserConvertor {
    public static UserEntity convertDtoToEntity (UserEntryDto userEntryDto){
        UserEntity userEntity = new UserEntity();

        // Set values using setters
        userEntity.setName(userEntryDto.getName());
        userEntity.setAge(userEntryDto.getAge());
        userEntity.setMobNo(userEntryDto.getMobNo());
        userEntity.setEmail(userEntryDto.getEmail());
        userEntity.setAddress(userEntryDto.getAddress());
        return  userEntity ;
    }

}
