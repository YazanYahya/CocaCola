package edu.birzeit.cocacola.application.model;


import javax.persistence.*;

@Entity
@Table(name="phones")
public class Phone {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private int userid;
    private String number;

    public Phone(){}
    
    public Phone(int userid, String number) {
        this.userid = userid;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", userid=" + userid +
                ", number='" + number + '\'' +
                '}';
    }
}
