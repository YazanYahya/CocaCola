package edu.birzeit.cocacola.application.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "truck_orders")
public class TruckOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "user_truck_driver_id")
    private User userTruckDriver;

    @ManyToOne
    @JoinColumn(name = "user_lori_id")
    private User userLori;

    private String state;
    private String notes;


    @OneToMany(mappedBy = "truckOrder", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;


    public TruckOrder() {
    }

    public TruckOrder(String state, String notes) {
        this.state = state;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    public User getUserTruckDriver() {
        return userTruckDriver;
    }

    public void setUserTruckDriver(User userTruckDriver) {
        this.userTruckDriver = userTruckDriver;
    }

    @JsonIgnore
    public User getUserLori() {
        return userLori;
    }

    public void setUserLori(User userLori) {
        this.userLori = userLori;
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

    @JsonIgnore
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "TruckOrder{" +
                "id=" + id +
                ", userTruckDriver=" + userTruckDriver +
                ", userLori=" + userLori +
                ", state='" + state + '\'' +
                ", notes='" + notes + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
