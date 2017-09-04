package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoryname;
    private String categorypicture;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
    @JsonIgnore
    private List<Product> products=new ArrayList<Product>();

    public Category() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getCategorypicture() {
        return categorypicture;
    }

    public void setCategorypicture(String categorypicture) {
        this.categorypicture = categorypicture;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryname='" + categoryname + '\'' +
                '}';
    }
}
