package ua.com.dao.impl;

import org.springframework.stereotype.Repository;
import ua.com.dao.ProductDAO;
import ua.com.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOimpl implements ProductDAO {
    @PersistenceContext
    private EntityManager manager;

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Product product) {
        manager.persist(product);
    }
    public List<Product> findAll() {
         return manager.createQuery("select p from Product p",Product.class).getResultList();
    }
    @SuppressWarnings("unchecked")
    public List<Product> findSearchingResult(String serch) {
        return manager.createQuery("select p from Product p where p.productname=?").setParameter(0,serch).getResultList();
    }
    @SuppressWarnings("unchecked")
    public Product findOne(int id) {
        List<Product> products=new ArrayList<Product>();
        products=manager.createQuery("select p from Product p where id=?").setParameter(0,id).getResultList();

        if (products.size() > 0) {
            return products.get(0);
        } else {
            return null;
        }
    }

    public void delete(int id) {
        manager.createQuery("delete from Product p where p.id=?").setParameter(0,id).executeUpdate();
        System.out.println("a"+id);
    }

    public void editProduct(String name,int price,String description,String picture,int id) {
        manager.createQuery("update Product p set p.productname=?1,  p.price=?2,  p.productdescription=?3,p.productpicture=?4 where p.id=?5")
        .setParameter(1,name).setParameter(2,price).setParameter(3,description).setParameter(4,picture).setParameter(5,id).executeUpdate();
    }

}
