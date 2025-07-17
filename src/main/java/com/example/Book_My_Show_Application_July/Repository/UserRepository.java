package com.example.Book_My_Show_Application_July.Repository;

//import org.apache.catalina.User;
import com.example.Book_My_Show_Application_July.Entites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
