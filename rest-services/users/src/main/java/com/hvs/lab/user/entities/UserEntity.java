package com.hvs.lab.user.entities;

import lombok.Data;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private long dni;
    private String name;
    private String surname;
    private LocalDate birthday;

}
