package ua.com.dao;


import ua.com.entity.Category;
import ua.com.entity.Product;

import java.util.List;

public interface CategoryDAO {

    void save(Category category);

    Category findOne(int id);

    List<Category> findAll();

    Category findCategoryWithProduct(int id);

    List<Product> findProductsByCategory(int id);


}
