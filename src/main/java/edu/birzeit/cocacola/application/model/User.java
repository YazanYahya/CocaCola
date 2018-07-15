package edu.birzeit.cocacola.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Transient
    public static final int MANAGER_ROLE=2;
    @Transient
    public static final int LORI_ROLE=1;
    @Transient
    public static final int TRUCK_DRIVER_ROLE=0;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int role;
    private String address;
    private String image;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phones;


    @OneToOne(mappedBy = "user")
    private Credential credential;


    @OneToMany(mappedBy = "userTruckDriver", cascade = CascadeType.ALL)
    private List<TruckOrder> truckOrders;


    @OneToMany(mappedBy = "userLori", cascade = CascadeType.ALL)
    private List<TruckOrder> loriServedOrders;


    public User(int id) {
        this.id = id;
    }

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
    public List<TruckOrder> getTruckOrders() {
        return truckOrders;
    }

    public void setTruckOrders(List<TruckOrder> truckOrders) {
        this.truckOrders = truckOrders;
    }

    @JsonIgnore
    public List<TruckOrder> getLoriServedOrders() {
        return loriServedOrders;
    }

    public void setLoriServedOrders(List<TruckOrder> loriServedOrders) {
        this.loriServedOrders = loriServedOrders;
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
                ", truckOrders=" + truckOrders +
                ", loriServedOrders=" + loriServedOrders +
                '}';
    }
}
