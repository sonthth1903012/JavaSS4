package com.example.auth.controller;


import com.example.auth.model.Product;
import com.example.auth.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    //DI call model step 2
    @Autowired
    ProductRepository productRepository;

    //index
    @RequestMapping("/")
    public String index(Model model) {
        List<Product> users = (List<Product>) productRepository.findAll();
        //request.setAttribute("users"users);
        model.addAttribute("users", users);
        return "index";
    }

    //
    @RequestMapping(value = "/add")
    public String addUser(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    //
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Product product) {
        productRepository.save(product);
        return "redirect:/";
    }

    //
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editProduct(@RequestParam("id") Long userId, Model model) {
        Optional<Product> userEdit = productRepository.findById(userId);
        userEdit.ifPresent(user -> model.addAttribute("user", user));
        return "editProduct";
    }

    //
    @RequestMapping(value = "/delete")
    public String deleteProduct(@RequestParam("id") Long productId, Model model) {
        productRepository.deleteById(productId);
        return "redirect:/";
    }
}