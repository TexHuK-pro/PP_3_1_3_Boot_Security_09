package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class UserCreator {

    private RoleRepository roleRepository;

    @Autowired
    public UserCreator(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_USER = "ROLE_USER";


    public List<User> createUsersWithRoles() {
        //roleRepository.save(new Role(1L, ROLE_USER));
        //roleRepository.save(new Role(2L, ROLE_ADMIN));
        //HashSet<Role> roles = new HashSet<>();
        //roles.add(new Role(1L, ROLE_USER));
        //roles.add(new Role(2L, ROLE_ADMIN));
        User user = new User("user", "user", "123@123", List.of(ROLE_USER));
        User admin = new User("admin", "admin", "321@21`", List.of(ROLE_ADMIN, ROLE_USER));
        return List.of(admin, user);
    }
}
