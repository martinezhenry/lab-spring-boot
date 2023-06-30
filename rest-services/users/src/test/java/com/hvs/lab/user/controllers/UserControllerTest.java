package com.hvs.lab.user.controllers;

import com.hvs.lab.user.exceptions.UserNotFoundException;
import com.hvs.lab.user.models.UserDTO;
import com.hvs.lab.user.services.impl.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;
    @MockBean
    private UserService userService;


    void otro() throws UserNotFoundException {

        Mockito.when(userService.getUser(Mockito.any())).thenReturn(new UserDTO());

        Mockito
    }


    @Test
    void getUserSuccessfulTest() throws UserNotFoundException {
        // Given
        var userId = 1000;

        Mockito.when(userService.getUser(userId)).thenReturn(new UserDTO());

        // When
        Assertions.assertDoesNotThrow(() -> {
            var user = userController.getUser(userId);
            Assertions.assertNotNull(user);
        });

        // Then
        Mockito.verify(userService, Mockito.times(1)).getUser(userId);
    }

    @Test
    void getUserFailsWithUserNotFoundTest() throws UserNotFoundException {
        // Given
        var userId = 1000;
        var exceptionExpected = new UserNotFoundException("User not found");

        Mockito.when(userService.getUser(userId)).thenThrow(exceptionExpected);

        // When
        Assertions.assertDoesNotThrow(() -> {
            var user = userController.getUser(userId);
            Assertions.assertNotNull(user);
        });

        // Then
        Mockito.verify(userService, Mockito.times(1)).getUser(userId);
    }

    @Test
    void createUser() {
    }

    @Test
    void modifyUser() {
    }

    @Test
    void deleteUser() {
    }
}