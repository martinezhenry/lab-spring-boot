package com.hvs.lab.user.services;

import com.hvs.lab.user.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Service
public class UserService {


    public User getUser(long id){
        if (id == 1) {
            User user = new User();
            user.setId(1);
            user.setName("Edinson");
            user.setSurname("Caceres");
            user.setDni(1023456789);
            user.setBirthday(LocalDate.now());
            return user;

        }

        return null;
    }


    public User createUser(User user){
        user.setId(2);
        return user;
    }

    public User modifyUser(User user) {
        User rspUser = this.getUser(user.getId());
        if (rspUser != null) {
            rspUser = user;
        }
        return rspUser;
    }

    public boolean deleteUser(long id) {

        if (id == 1) {
            return true;
        }
        return false;
    }

}
