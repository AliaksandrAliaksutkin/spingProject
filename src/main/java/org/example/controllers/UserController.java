package org.example.controllers;

import org.example.model.Address;
import org.example.service.UserService;
import org.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public String create (@RequestParam(required = false) Long id,
                           @RequestParam ("firstName") String firstName,
                           @RequestParam ("lastName") String lastName,
                           @RequestParam ("age") int age,
                           @RequestParam(name = "address.city") String city,
                           @RequestParam(name = "address.street") String street,
                           @RequestParam(name = "address.house") Integer house) {
        User user = new User(id, firstName, lastName, age, new Address(city, street, house));
        userService.create(user);
        return "redirect:/users";
    }

//    @GetMapping("/delete")
//    public String delete(@RequestParam Long id) {
//        userService.getById(id);
//        return "redirect:/users";
//    }

}