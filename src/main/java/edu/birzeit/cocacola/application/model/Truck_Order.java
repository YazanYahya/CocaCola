package edu.birzeit.cocacola.application.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "truck_orders")
public class Truck_Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne
    @JoinColumn(name = "user_truck_driver_id")
    private User user_truck_driver;

    @ManyToOne
    @JoinColumn(name = "user_lori_id")
    private User user_lori;

    private String state;
    private String notes;


    @OneToMany(mappedBy = "truck_order", cascade = CascadeType.ALL)
    private List<Order_Detail> order_details;


    public Truck_Order() {
    }

    public Truck_Order(String state, String notes) {
        this.state = state;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_truck_driver() {
        return user_truck_driver;
    }

    public void setUser_truck_driver(User user_truck_driver) {
        this.user_truck_driver = user_truck_driver;
    }

    public User getUser_lori() {
        return user_lori;
    }

    public void setUser_lori(User user_lori) {
        this.user_lori = user_lori;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Order_Detail> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(List<Order_Detail> order_details) {
        this.order_details = order_details;
    }

    @Override
    public String toString() {
        return "Truck_Order{" +
                "id=" + id +
                ", user_truck_driver=" + user_truck_driver +
                ", user_lori=" + user_lori +
                ", state='" + state + '\'' +
                ", notes='" + notes + '\'' +
                ", order_details=" + order_details +
                '}';
    }
}
