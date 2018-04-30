package ua.com.alistratenko.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.alistratenko.entity.ProductCategory;
import ua.com.alistratenko.entity.User;
import ua.com.alistratenko.entity.UserRole;
import ua.com.alistratenko.service.UserService;

import java.util.List;

@Controller
public class HelloContoller {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model){

        userService.getAllUsers();
        return "welcome";
    }
}
