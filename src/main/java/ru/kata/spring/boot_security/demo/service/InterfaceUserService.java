package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface InterfaceUserService extends UserDetailsService {
    User findUserById(Long userId);
    List<User> allUsers();
    boolean deleteUser(Long userId);
    List<Role> getRoles();
    List<User> usergtList(Long idMin);
}
