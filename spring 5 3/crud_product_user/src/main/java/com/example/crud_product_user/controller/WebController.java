package t1907m.springboot_crud_product_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1907m.springboot_crud_product_user.validator.UserValidator;
import t1907m.springboot_crud_product_user.model.User;
import t1907m.springboot_crud_product_user.service.UserService;

@Controller
public class WebController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping(path = {"/login", ""})
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/home")
    public String home() {
        return "index";
    }

    @RequestMapping(path = "/registration")
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("user") User user, BindingResult result, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            //model.addAttribute("user",user);
            return "registration";
        } else {
            userService.save(user);
            return "redirect:/registration?success";
        }

    }


}
