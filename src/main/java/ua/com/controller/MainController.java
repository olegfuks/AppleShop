package ua.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.editor.CategoryEditor;
import ua.com.entity.Category;
import ua.com.entity.Product;
import ua.com.entity.User;
import ua.com.service.CategoryService;
import ua.com.service.ProductService;
import ua.com.service.UserService;

import java.io.File;
import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryEditor categoryEditor;

    @GetMapping("/")
    public String toMainPage(Model model) {
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("products",productService.findAll());
        return "index";
    }

    @GetMapping("registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @PostMapping("registr")
    public String registr(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("email") String email,
                          @RequestParam("firstname") String firstname,
                          @RequestParam("lastname") String lastname) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        userService.save(user);
        return "redirect:/toLogin";
    }

    @GetMapping("admin")
    public String admin(Model model) {
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("products",productService.findAll());
        return "admin";
    }

    @PostMapping("/saveproduct")
    public String saveproduct(@ModelAttribute("emptyProduct") Product product,
                           @RequestParam("picture")MultipartFile multipartFile){

        String path="C:\\Users\\olegf\\Desktop\\Sombra_Test_Shop\\TMP\\";
        product.setProductpicture("/PICTURE/"+multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(new File(path+multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        productService.save(product);
        return "redirect:/admin";
    }
    @InitBinder("emptyProduct")
    public void binder(WebDataBinder binder){
        binder.registerCustomEditor(Category.class ,categoryEditor);
    }

    @ModelAttribute("emptyProduct")
    public Product product() {
        return new Product();
    }
    @ModelAttribute("emptyCategory")
    public Category category() {
        return new Category();
    }

    @PostMapping("savecategory")
    public String savecategory(@ModelAttribute("emptyCategory") @Validated Category category, BindingResult result ,
                               @RequestParam("pic")MultipartFile multipartFile) {
        if(result.hasErrors()){
            return "/";
        }
        String path = "C:\\Users\\olegf\\Desktop\\Sombra_Test_Shop\\TMP\\";
        category.setCategorypicture("/PICTURE/"+multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(new File(path+multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        categoryService.save(category);
        return "redirect:/admin";
    }
    @GetMapping("cart")
    public String cart(){
        return "cart";
    }
    @GetMapping("delete-{id}")
    public String delete(@PathVariable int id){
        productService.delete(id);
        System.out.println(id);
        return "redirect:/showallproducts";
    }
    @GetMapping("showallproducts")
    public String showallproducts(Model model){
        model.addAttribute("products",productService.findAll());
        return "showallproducts";
    }
    @GetMapping("showallusers")
    public String showallusers(Model  model){
        model.addAttribute("nonlockeduser",userService.findlockedNonLocked(true));
        model.addAttribute("lockeduser",userService.findlockedNonLocked(false));
        return "showallusers";
    }
    @GetMapping("unlockuser-{id}")
    public String unlockuser(@PathVariable int id){
        userService.lockedNonLocked(true,id);
        return "redirect:/showallusers";
    }
    @GetMapping("lockuser-{id}")
    public String lockuser(@PathVariable int id){
        userService.lockedNonLocked(false,id);
        return "redirect:/showallusers";
    }
    @GetMapping("edit-{id}")
    public String toEdit(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findOne(id));
        return "edit";
    }
    @PostMapping("/editproduct-{id}")
    public String editproduct(@RequestParam("productname") String productname,
                              @RequestParam("price") int price,
                              @RequestParam("productdescription") String productdescription,
                              @RequestParam("picture") MultipartFile multipartFile,
                              @PathVariable int id){
        String path="C:\\Users\\olegf\\Desktop\\Sombra_Test_Shop\\TMP\\";
        String pic="/PICTURE/"+multipartFile.getOriginalFilename();
        try {
            multipartFile.transferTo(new File(path+multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.editProduct(productname,price,productdescription,pic,id);
        return "redirect:/admin";
    }
}
