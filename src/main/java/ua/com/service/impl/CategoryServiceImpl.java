package ua.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.impl.CategoryDAOimpl;
import ua.com.entity.Category;
import ua.com.entity.Product;
import ua.com.service.CategoryService;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryDAOimpl categoryDAOimpl;

    public void save(Category category) {
        categoryDAOimpl.save(category);
    }

    public Category findOne(int id) {
        return categoryDAOimpl.findOne(id);
    }

    public List<Category> findAll() {
        return categoryDAOimpl.findAll();
    }

    public Category findCategoryWithProduct(int id) {
        return categoryDAOimpl.findCategoryWithProduct(id);
    }

    public List<Product> findProductsByCategory(int id) {
        return categoryDAOimpl.findProductsByCategory(id);
    }
}
