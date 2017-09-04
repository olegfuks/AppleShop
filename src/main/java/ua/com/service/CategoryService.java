package ua.com.service;


import ua.com.entity.Category;
import ua.com.entity.Product;

import java.util.List;

public interface CategoryService {
    void save(Category category);

    Category findOne(int id);

    List<Category> findAll();

    Category findCategoryWithProduct(int id);

    List<Product> findProductsByCategory(int id);
}
