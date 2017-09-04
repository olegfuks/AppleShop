package ua.com.dao.impl;

import org.springframework.stereotype.Repository;
import ua.com.dao.CategoryDAO;
import ua.com.entity.Category;
import ua.com.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAOimpl implements CategoryDAO {
    @PersistenceContext
    private EntityManager manager;

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Category category) {
        manager.persist(category);
    }
    @SuppressWarnings("unchecked")
    public Category findOne(int id) {
        List<Category> categories=new ArrayList<Category>();
        categories=manager.createQuery("select c from Category c where id=?").setParameter(0,id).getResultList();

        if (categories.size() > 0) {
            return categories.get(0);
        } else {
            return null;
        }
    }

    public List<Category> findAll() {
        return manager.createQuery("select c from Category c",Category.class).getResultList();
    }
    @SuppressWarnings("unchecked")
    public Category findCategoryWithProduct(int id) {
        List<Category> categories=new ArrayList<Category>();
        categories=manager.createQuery("from Category c join fetch c.products where c.id=?").setParameter(0,id).getResultList();

        if (categories.size() > 0) {
            return categories.get(0);
        } else {
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    public List<Product> findProductsByCategory(int id) {

        return manager.createQuery("from Category c join fetch c.products where c.id=?").setParameter(0,id).getResultList();
    }


}
