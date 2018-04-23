package ua.com.alistratenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.alistratenko.service.UserService;


@Controller
public class HelloContoller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model){
            model.addAttribute("users", userService.getAllUsers());
        return "welcome";
    }
}
