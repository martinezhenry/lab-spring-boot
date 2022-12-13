package com.hvs.lab.user.controllers;

import com.hvs.lab.user.models.User;
import com.hvs.lab.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User getUser(@PathVariable long id){
        return this.userService.getUser(id);
    }


    @PostMapping
    public User createUser(@RequestBody User user){
        return this.userService.createUser(user);
    }

    @PutMapping
    public User modifyUser(@RequestBody User user) {
        return this.userService.modifyUser(user);
    }


    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable long id) {
        if (!this.userService.deleteUser(id)){
            throw new RuntimeException("User Not Deleted");
        }
    }



}
