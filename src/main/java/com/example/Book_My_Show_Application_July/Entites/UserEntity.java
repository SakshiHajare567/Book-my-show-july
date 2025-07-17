package com.example.Book_My_Show_Application_July.Entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;

    private int age ;

    @Column(unique = true , nullable = false)
    private String email ;

    @Column(unique = true , nullable = false)
    private String mobNo ;

    private String address ;

    //parent:user Entity connect to child:ticket Entity
    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<TicketEntity>bookedTickets=new ArrayList<>();


    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<TicketEntity> getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(List<TicketEntity> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

}
