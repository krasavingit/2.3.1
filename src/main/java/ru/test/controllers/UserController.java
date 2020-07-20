package ru.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.test.dao.UserDao;
import ru.test.models.User;
import ru.test.service.UserService;

import java.sql.SQLOutput;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String Home(Model model){
        return "home";
    }
    @GetMapping("/hello")
    public String Hello (Model model){
        return "hello";
    }
    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("userlist", userService.getAll());
        return "users";
    }
    @PostMapping("deleteUser")
    public String deleteUser(@RequestParam("id") Long id, Model model){
        model.addAttribute("id", id);
        userService.deleteById(id);
        return "redirect:/users";
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.add(user);

        return "redirect:/users";
    }
    @PostMapping("editUser")
    public String editForm(@RequestParam("id") Long id, @ModelAttribute("user") User user, Model model){
        model.addAttribute("id", id);
        if(id!=0& id>=userService.getAll().size()) {
            userService.edit(user);
        }
        return "redirect:/users";
    }
    @PostMapping("/error")
    public String error(Model model){
        model.addAttribute("notExist","User with such id does not exists");
        return "redirect:/users";
    }
}