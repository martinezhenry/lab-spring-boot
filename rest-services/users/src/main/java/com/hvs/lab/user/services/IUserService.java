package com.hvs.lab.user.services;

import com.hvs.lab.user.exceptions.UserNotFoundException;
import com.hvs.lab.user.exceptions.UserNotModifiedException;
import com.hvs.lab.user.models.UserDTO;

public interface IUserService {
    UserDTO getUser(long id) throws UserNotFoundException;
    UserDTO createUser(UserDTO user);
    UserDTO modifyUser(UserDTO user) throws UserNotModifiedException;
    boolean deleteUser(long id) throws UserNotFoundException;
}
