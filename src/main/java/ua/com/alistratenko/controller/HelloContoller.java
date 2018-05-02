package ua.com.alistratenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.alistratenko.entity.User;
import ua.com.alistratenko.entity.UserRole;
import ua.com.alistratenko.service.UserRoleService;
import ua.com.alistratenko.service.UserService;

@Controller
public class HelloContoller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public String getAllUsers(){
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
        return "welcome";
    }

    @RequestMapping(value = "/userByLogin/{userLogin}", method = RequestMethod.GET)
    public String getUserByLogin(@PathVariable("userLogin") String userLogin){
        System.out.println(userService.getUserByLogin(userLogin));
        return "welcome";
    }

    @RequestMapping(value = "/userByEmail/{email}", method = RequestMethod.GET)
    public String getUserByEmail(@PathVariable("email") String email){
        System.out.println(userService.getUserByEmail(email));
        return "welcome";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String getNewUserPage(ModelMap model){
        model.addAttribute(new User());
        model.addAttribute("userRolesList", userRoleService.getAllUserRoles());
        for (UserRole role : userRoleService.getAllUserRoles()) {
            System.out.println(role.getName());
            for (User user : role.getUsers()) {
                System.out.println("   " + user.getEmail());
            }
        }

        return "createUser";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createNewUser(ModelMap model){
        return "welcome";
    }


}
