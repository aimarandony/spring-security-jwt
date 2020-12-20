package com.example.demosecurity;

import com.example.demosecurity.model.Role;
import com.example.demosecurity.model.User;
import com.example.demosecurity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class DemoSecurityApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... params) throws Exception {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setEmail("admin@email.com");
        admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

        userService.signup(admin);

        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setEmail("user@email.com");
        user.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_USER)));

        userService.signup(user);

        User admin2 = new User();
        admin2.setUsername("andony");
        admin2.setPassword("admin");
        admin2.setEmail("andony@email.com");
        admin2.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_USER, Role.ROLE_ADMIN)));

        userService.signup(admin2);
    }
}
