package com.hvs.lab.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hvs.lab.user.entities.User;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}