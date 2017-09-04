package ua.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.ProductDAO;
import ua.com.entity.Product;
import ua.com.service.ProductService;

import java.util.List;

@Service
@Transactional
class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDAO productDAO;
    public void save(Product product) {
        productDAO.save(product);
    }

    public List<Product> findAll() {
        return productDAO.findAll();
    }

    public List findSearchingResult(String serch) {
        return productDAO.findSearchingResult(serch);
    }

    public Product findOne(int id) {
        return productDAO.findOne(id);
    }

    public void delete(int id) {
        productDAO.delete(id);
    }

    public void editProduct(String name,int price,String description,String picture,int id) {
        productDAO.editProduct(name,price,description,picture,id);
    }
}
