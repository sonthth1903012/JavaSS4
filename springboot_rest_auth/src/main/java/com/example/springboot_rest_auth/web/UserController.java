package com.example.springboot_rest_auth.web;

import com.example.springboot_rest_auth.model.User;
import com.example.springboot_rest_auth.service.SercurityService;
import com.example.springboot_rest_auth.service.UserService;
import com.example.springboot_rest_auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SercurityService sercurityService;
    @Autowired
    private UserValidator userValidator;
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm",new User());
        return "registration";
    }
    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        sercurityService.autoLogin(userForm.getUsername(), userForm.getPassword());
        return "redirect:/welcome";
    }
    @GetMapping("/login")
    public String login(Model model, String error, String loggout) {
        if (error != null)
            model.addAttribute("error","Invalid username or password!");

        if (loggout != null)
            model.addAttribute("message","Logged out successfully!");
        return "login";
    }
    @GetMapping({"/","welcome"})
    public String welcome(Model model){
        return "welcome";
    }
}
