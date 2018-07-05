package edu.birzeit.cocacola.application.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int quantity;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<Product> products;

    public Inventory() {
    }

    public Inventory(int quantity) {
        this.quantity = quantity;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", products=" + products +
                '}';
    }
}
