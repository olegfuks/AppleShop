package ua.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.CartDAO;
import ua.com.entity.Cart;
import ua.com.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    CartDAO cartDAO;

    public void save(Cart cart) {
        cartDAO.save(cart);
    }
}
