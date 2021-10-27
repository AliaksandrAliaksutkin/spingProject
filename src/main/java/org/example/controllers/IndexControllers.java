package org.example.controllers;

import org.example.exception.NoEntityException;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class IndexControllers {
    private final UserService userService;

    public IndexControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index (Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

//    @GetMapping(value = "/add")
//    public String addUser(Model model, User user) {
//        model.addAttribute(user);
//        return "userModel";
//    }
//
//    @GetMapping("/UserAddress")
//    public String getAddress(Model model, @RequestParam Long id) throws NoEntityException {
//        User userAddress = userService.getById(id);
//        model.addAttribute("userAddress", userAddress);
//        return "userAddress";
//    }
//
//    @GetMapping("/editUser")
//    public String editUser(Model model, @RequestParam Long id) throws NoEntityException {
//        model.addAttribute(userService.getById(id));
//        return "userModel";
//    }

}
