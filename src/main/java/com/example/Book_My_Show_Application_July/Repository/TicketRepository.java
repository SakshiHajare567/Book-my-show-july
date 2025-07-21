package com.example.Book_My_Show_Application_July.Repository;

import com.example.Book_My_Show_Application_July.Entites.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity ,Integer> {
}
