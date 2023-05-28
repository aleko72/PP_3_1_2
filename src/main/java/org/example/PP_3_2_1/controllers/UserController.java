package org.example.PP_3_2_1.controllers;

import org.example.PP_3_2_1.models.User;
import org.example.PP_3_2_1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "users/details";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("user") User user){
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/users";
    }
}
