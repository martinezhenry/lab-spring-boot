package com.hvs.lab.user.repositories;

import com.hvs.lab.user.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}