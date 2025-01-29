package com.example.proloco.Controller;

import ch.qos.logback.classic.Logger;
import com.example.proloco.Model.User;
import com.example.proloco.Service.UserService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@RestController
public class UserController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/user")
    public User getUser(@RequestParam int id) {
        return userService.getUser(id);
    }

    @GetMapping("/userFromDB")
    public User getUserFromDB(@RequestParam int id) {
        return userService.getUserFromDB(id);
    }

    @PostMapping("/addUser")
    public void addUserToList(@RequestBody User user) {
        userService.setUser(user);
    }

    @PostMapping("/addListToDB")
    public void addUserToDB(@RequestBody User user) {
        // TODO: miglorare questo metodo, fare in modo che restituisca una risposta se è andata bene o no
        try {
            userService.insertUserIntoDB(user);
        } catch (IOException | InvalidFormatException e) {
            log.error("Error adding users to DB", e);
            throw new RuntimeException(e);
        }
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
