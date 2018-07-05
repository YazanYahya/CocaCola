package edu.birzeit.cocacola.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class Order_Detail {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int quantity;


    @ManyToOne
    @JoinColumn(name = "truck_order_id")
    private Truck_Order truck_order;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    public Order_Detail() {
    }

    public Order_Detail(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    public Truck_Order getTruck_order() {
        return truck_order;
    }

    public void setTruck_order(Truck_Order truck_order) {
        this.truck_order = truck_order;
    }

    @JsonIgnore
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order_Detail{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", truck_order=" + truck_order +
                ", product=" + product +
                '}';
    }
}
