package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;


@Component
public class DataInitializer {

    @Autowired
    private UserService userService;

    @org.springframework.context.event.EventListener(org.springframework.context.event.ContextRefreshedEvent.class)
    public void init() {

        if (userService.getAllUsers().isEmpty()) {

            userService.saveUser(new User("John", "Doe", "john@example.com", 25, "+1234567890"));
            userService.saveUser(new User("Jane", "Smith", "jane@example.com", 30, "+0987654321"));
            userService.saveUser(new User("Bob", "Johnson", "bob@example.com", 35, "+1122334455"));
            userService.saveUser(new User("Alice", "Brown", "alice@example.com", 28, "+1555666777"));
            System.out.println("4 test users added successfully!");
        }
    }
}