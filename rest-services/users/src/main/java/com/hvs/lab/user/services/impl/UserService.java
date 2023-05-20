package com.hvs.lab.user.services.impl;

import com.hvs.lab.user.entities.UserEntity;
import com.hvs.lab.user.exceptions.UserNotFoundException;
import com.hvs.lab.user.exceptions.UserNotModifiedException;
import com.hvs.lab.user.models.UserDTO;
import com.hvs.lab.user.repositories.UserRepository;
import com.hvs.lab.user.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUser(long id) throws UserNotFoundException {

        Optional<UserEntity> userEntity = userRepository.findById(id);
        // Con el uso de la clase Optional validamos si existe el usuario consultado con el id
        // sino disparamos una exepcion
        userEntity.orElseThrow(
                () -> new UserNotFoundException(String.format("El usuario con el id %s no existe", id))
        );

        UserDTO userDTO = new UserDTO();
        userDTO.setName(userEntity.get().getName());
        userDTO.setSurname(userEntity.get().getSurname());
        userDTO.setBirthday(userEntity.get().getBirthday());
        userDTO.setDni(userEntity.get().getDni());
        userDTO.setId(userEntity.get().getId());
        return userDTO;

    }


    public void getAllUsers(){}


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setSurname(userDTO.getSurname());
        userEntity.setBirthday(userDTO.getBirthday());
        userEntity.setDni(userDTO.getDni());
        userEntity.setId(userDTO.getId());

        // El metodo save() permite insertar y actualizar los datos de la entidad User
        userEntity = userRepository.save(userEntity);

        userDTO.setId(userEntity.getId());

        return userDTO;
    }

    @Override
    public UserDTO modifyUser(UserDTO userDTO) throws UserNotModifiedException {
        try {
            UserDTO rspUserDTO = this.getUser(userDTO.getId());
            if (rspUserDTO != null) {
                rspUserDTO = createUser(userDTO);
            } else {

            }
            return rspUserDTO;
        } catch (UserNotFoundException exception) {
            log.error(String.format("El usuario %s no existe, por lo tanto no fue modificado", userDTO.getId()));
            throw new UserNotModifiedException(String.format("El usuario %s no existe, por lo tanto no fue modificado", userDTO.getId()));

        }

    }

    @Override
    public boolean deleteUser(long id) throws UserNotFoundException {
        UserDTO rspUserDTO = this.getUser(id);
        if (rspUserDTO != null) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
