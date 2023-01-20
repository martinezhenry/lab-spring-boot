package com.hvs.lab.user.services;

import com.hvs.lab.user.entities.UserEntity;
import com.hvs.lab.user.exceptions.UserNotFoundException;
import com.hvs.lab.user.models.User;
import com.hvs.lab.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUser(long id) throws UserNotFoundException {

        Optional<UserEntity> userEntity = userRepository.findById(id);
        // Con el uso de la clase Optional validamos si existe el usuario consultado con el id
        // sino disparamos una exepcion
        userEntity.orElseThrow(UserNotFoundException::new);

        User user = new User();
        user.setName(userEntity.get().getName());
        user.setSurname(userEntity.get().getSurname());
        user.setBirthday(userEntity.get().getBirthday());
        user.setDni(userEntity.get().getDni());
        user.setId(userEntity.get().getId());
        return user;

    }


    public User createUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setSurname(user.getSurname());
        userEntity.setBirthday(user.getBirthday());
        userEntity.setDni(user.getDni());

        // El metodo save() permite insertar y actualizar los datos de la entidad User
        userEntity = userRepository.save(userEntity);

        user.setId(userEntity.getId());

        return user;
    }

    public User modifyUser(User user) throws UserNotFoundException {
        User rspUser = this.getUser(user.getId());
        if (rspUser != null) {
            rspUser = createUser(user);
        }
        return rspUser;
    }

    public boolean deleteUser(long id) throws UserNotFoundException {
        User rspUser = this.getUser(id);
        if (rspUser != null) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
