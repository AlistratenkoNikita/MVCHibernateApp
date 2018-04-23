package ua.com.alistratenko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.alistratenko.entity.User;

@Controller
public class RegisterUserController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(ModelMap model){
        model.addAttribute("user", new User());
        return "registerUser";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("user") User user){
        System.out.println(user);
        return "welcome";
    }
}
