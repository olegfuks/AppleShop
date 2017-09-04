package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String productname;
    @Column(columnDefinition = "TEXT")
    private String productdescription;
    private int price;
    private String productpicture;
    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.MERGE)
    @JsonIgnore
    private Category category;

    public Product() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProductpicture() {
        return productpicture;
    }

    public void setProductpicture(String productpicture) {
        this.productpicture = productpicture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", productdescription='" + productdescription + '\'' +
                ", price=" + price +
                '}';
    }
}
