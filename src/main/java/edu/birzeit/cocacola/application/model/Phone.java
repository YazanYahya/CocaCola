package edu.birzeit.cocacola.application.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", user=" + user +
                '}';
    }
}
