package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("admin")
    public String findAll(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        model.addAttribute("roleList", userService.getRoles());
        return "admin/admin-list";
    }

    @GetMapping("admin-create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User() );
        model.addAttribute("users_roles", userService.getRoles());
        return "admin/admin-create";
    }

    @PostMapping("admin-create")
    public String createUser(User user) {
        user.setRoles(user.getRoles());
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("admin-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);
        System.out.println(user);
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("roleList", userService.getRoles());
        return "/admin/admin-update";
    }

    @PostMapping("admin-update")
    public String updateUser(User user) {
        user.setRoles(user.getRoles());
        System.out.println("Post user-update " + user);
        userService.saveUser(user);
        return "redirect:/admin";
    }

}
