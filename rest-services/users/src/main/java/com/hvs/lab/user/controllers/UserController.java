package com.hvs.lab.user.controllers;

import com.hvs.lab.user.exceptions.UserNotFoundException;
import com.hvs.lab.user.exceptions.UserNotModifiedException;
import com.hvs.lab.user.models.UserDTO;
import com.hvs.lab.user.services.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("{id}")
    public UserDTO getUser(@PathVariable long id) throws UserNotFoundException {
        return this.userService.getUser(id);
    }


    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return this.userService.createUser(userDTO);
    }

    @PutMapping
    public UserDTO modifyUser(@RequestBody UserDTO userDTO) throws UserNotModifiedException {
        return this.userService.modifyUser(userDTO);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable long id) throws UserNotFoundException {
        if (!this.userService.deleteUser(id)){
            throw new RuntimeException("User Not Deleted");
        }
    }

}
