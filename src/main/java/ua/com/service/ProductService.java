package ua.com.service;

import ua.com.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    List<Product> findAll();

    List findSearchingResult(String serch);

    Product findOne(int id);

    void delete(int id);

    void editProduct(String name, int price, String description, String picture, int id);

}
