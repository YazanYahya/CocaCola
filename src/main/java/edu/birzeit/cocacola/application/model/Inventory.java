package edu.birzeit.cocacola.application.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;


    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Inventory() {
    }

    public Inventory(int quantity) {
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
    public Product getProduct() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }


    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
