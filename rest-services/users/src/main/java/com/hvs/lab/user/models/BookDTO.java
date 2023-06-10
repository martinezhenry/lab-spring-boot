package com.hvs.lab.user.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDTO {
    private long id;
    private long ISNB;
    private String titulo;
    private String descripcion;

}
