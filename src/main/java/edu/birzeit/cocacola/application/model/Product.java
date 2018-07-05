package edu.birzeit.cocacola.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;
    private String qrcode;
    private String category;
    private String image;
    private double price;
    private int items_per_box;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Inventory inventory;


    @OneToOne(mappedBy = "product")
    private Order_Detail order_detail;


    public Product() {
    }

    public Product(String description, String qrcode, String category, String image, double price, int items_per_box) {
        this.description = description;
        this.qrcode = qrcode;
        this.category = category;
        this.image = image;
        this.price = price;
        this.items_per_box = items_per_box;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItems_per_box() {
        return items_per_box;
    }

    public void setItems_per_box(int items_per_box) {
        this.items_per_box = items_per_box;
    }

    @JsonIgnore
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @JsonIgnore
    public Order_Detail getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(Order_Detail order_detail) {
        this.order_detail = order_detail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", qrcode='" + qrcode + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", items_per_box=" + items_per_box +
                ", inventory=" + inventory +
                ", order_detail=" + order_detail +
                '}';
    }
}
