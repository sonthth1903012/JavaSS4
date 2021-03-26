package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    //DI call model step 2
    @Autowired
    UserRepository userRepository;

    //index
    @RequestMapping("/")
    public String index(Model model){
        List<User> users = (List<User>) userRepository.findAll();
        //request.setAttribute("users"users);
        model.addAttribute( "users",users);
        return "index";
    }

    //
    @RequestMapping(value = "add")
    public String addUser(Model model){
        model.addAttribute( "user",new User());
        return "addUser";
    }

    //
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    //
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Long userId, Model model){
        Optional<User> userEdit = userRepository.findById(userId);
        userEdit.ifPresent(user ->model.addAttribute( "user",user) );
        return "editUser";
    }

    //
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public String deleteUsed(@RequestParam("id") Long userId,Model model){
        userRepository.deleteById(userId);
        return "redirect:/";
    }
}