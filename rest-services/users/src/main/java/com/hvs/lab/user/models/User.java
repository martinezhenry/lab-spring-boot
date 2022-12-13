package com.hvs.lab.user.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private long id;
    private long dni;
    private String name;
    private String surname;
    private LocalDate birthday;

}
