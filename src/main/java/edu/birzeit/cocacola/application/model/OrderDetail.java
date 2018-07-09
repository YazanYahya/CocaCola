package edu.birzeit.cocacola.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;


    @ManyToOne
    @JoinColumn(name = "truck_order_id")
    private TruckOrder truckOrder;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(int quantity) {
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
    public TruckOrder getTruckOrder() {
        return truckOrder;
    }

    public void setTruckOrder(TruckOrder truckOrder) {
        this.truckOrder = truckOrder;
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
        return "OrderDetail{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", truckOrder=" + truckOrder +
                ", product=" + product +
                '}';
    }
}
