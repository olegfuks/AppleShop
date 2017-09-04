package ua.com.dao.impl;

import org.springframework.stereotype.Repository;
import ua.com.dao.CartDAO;
import ua.com.entity.Cart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CartDAOimpl implements CartDAO{
    @PersistenceContext
    private EntityManager manager;

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Cart cart) {
        manager.persist(cart);
    }
}
