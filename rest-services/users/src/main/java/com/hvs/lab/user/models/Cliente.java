package com.hvs.lab.user.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Cliente {
    private long id;
    private long dni;
    private String name;
    private String surname;
    private LocalDate birthday;

}
