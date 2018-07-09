package edu.birzeit.cocacola.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String QRCode;
    private String category;
    private String image;
    private double price;
    private int itemsPerBox;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Inventory inventory;


    @OneToOne(mappedBy = "product")
    private OrderDetail orderDetail;


    public Product() {
    }

    public Product(String description, String QRCode, String category, String image, double price, int itemsPerBox) {
        this.description = description;
        this.QRCode = QRCode;
        this.category = category;
        this.image = image;
        this.price = price;
        this.itemsPerBox = itemsPerBox;
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

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
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

    public int getItemsPerBox() {
        return itemsPerBox;
    }

    public void setItemsPerBox(int itemsPerBox) {
        this.itemsPerBox = itemsPerBox;
    }

    @JsonIgnore
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @JsonIgnore
    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", QRCode='" + QRCode + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", itemsPerBox=" + itemsPerBox +
                ", inventory=" + inventory +
                ", orderDetail=" + orderDetail +
                '}';
    }
}
