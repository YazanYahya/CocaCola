package edu.birzeit.cocacola.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int role;
    private String address;
    private String image;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phones;


    @OneToOne(mappedBy = "user")
    private Credential credential;


    @OneToMany(mappedBy = "user_truck_driver", cascade = CascadeType.ALL)
    private List<Truck_Order> truck_orders;


    @OneToMany(mappedBy = "user_lori", cascade = CascadeType.ALL)
    private List<Truck_Order> lori_served_orders;


    public User() {
    }

    public User(String name, int role, String address, String image) {
        this.name = name;
        this.role = role;
        this.address = address;
        this.image = image;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @JsonIgnore
    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @JsonIgnore
    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    @JsonIgnore
    public List<Truck_Order> getTruck_orders() {
        return truck_orders;
    }

    public void setTruck_orders(List<Truck_Order> truck_orders) {
        this.truck_orders = truck_orders;
    }

    @JsonIgnore
    public List<Truck_Order> getLori_served_orders() {
        return lori_served_orders;
    }

    public void setLori_served_orders(List<Truck_Order> lori_served_orders) {
        this.lori_served_orders = lori_served_orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                ", phones=" + phones +
                ", credential=" + credential +
                ", truck_orders=" + truck_orders +
                ", lori_served_orders=" + lori_served_orders +
                '}';
    }
}
