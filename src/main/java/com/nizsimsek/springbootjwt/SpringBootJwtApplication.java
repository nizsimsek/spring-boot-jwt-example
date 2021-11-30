package com.nizsimsek.springbootjwt;

import com.nizsimsek.springbootjwt.model.Role;
import com.nizsimsek.springbootjwt.model.User;
import com.nizsimsek.springbootjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringBootJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJwtApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    CommandLineRunner runner(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(
                    new User(null, "ali", "ali@email.com", "Ali",
                            "Günay", "password", new ArrayList<>()));
            userService.saveUser(
                    new User(null, "mehmet", "mehmet@email.com", "Mehmet",
                            "Günay", "password", new ArrayList<>()));
            userService.saveUser(
                    new User(null, "admin", "admin@email.com", "Nizamettin",
                            "Şimşek", "password", new ArrayList<>()));
            userService.saveUser(
                    new User(null, "deniz", "deniz@email.com", "Deniz",
                            "Aksu", "password", new ArrayList<>()));

            userService.addRoleToUser("ali", "ROLE_USER");
            userService.addRoleToUser("mehmet", "ROLE_USER");
            userService.addRoleToUser("mehmet", "ROLE_MANAGER");
            userService.addRoleToUser("admin", "ROLE_ADMIN");
            userService.addRoleToUser("admin", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("deniz", "ROLE_ADMIN");
            userService.addRoleToUser("deniz", "ROLE_SUPER_ADMIN");
        };
    }
}
