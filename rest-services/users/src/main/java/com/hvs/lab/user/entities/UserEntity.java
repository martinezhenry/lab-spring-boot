package com.hvs.lab.user.entities;

import lombok.Data;

import java.time.LocalDate;
import javax.persistence.*;


@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private long dni;
    private String name;
    private String surname;
    private LocalDate birthday;

}
