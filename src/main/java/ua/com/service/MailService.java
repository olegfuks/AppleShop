package ua.com.service;


import ua.com.entity.Product;
import ua.com.entity.User;

public interface MailService {
    void send(User user, Product product);
}
