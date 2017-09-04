package ua.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.com.entity.Cart;
import ua.com.entity.Product;
import ua.com.service.*;

import java.util.List;

@RestController
public class MyRESTController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;
    @Autowired
    MailService mailService;

    @GetMapping("/searchproduct")
    public List<Product> searchproduct (){
        return productService.findAll();
    }

    @GetMapping("ava-{id}")
    public List<Product> ava(@PathVariable int id){
        return categoryService.findCategoryWithProduct(id).getProducts();
    }

    @GetMapping("/show-cart-{id}")
    public  void saveToCart(@PathVariable int id) throws Exception {
        Cart cart= new Cart();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        try {
            cart.setProductname(productService.findOne(id).getProductname());
            cart.setBuyer(username);
            cart.setPrice(productService.findOne(id).getPrice());
            mailService.send(userService.findByUserName(username), productService.findOne(id));
            cartService.save(cart);
        }
        catch (Exception e){
            throw new Exception("Fail!",e);
        }
    }
}
