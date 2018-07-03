package com.ramllah.cocacola.application.product;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;
    private String qrcode;
    private String category;
    private double price;
    private int items_per_box;

    public Product(){}

    public Product(int id, String description, String qrcode, String category, double price, int items_per_box) {
        this.id = id;
        this.description = description;
        this.qrcode = qrcode;
        this.category = category;
        this.price = price;
        this.items_per_box= items_per_box;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItem_per_box() {
        return items_per_box;
    }

    public void setItem_per_box(int item_per_box) {
        this.items_per_box = item_per_box;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", qrcode='" + qrcode + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", item_per_box=" + items_per_box +
                '}';
    }
}
