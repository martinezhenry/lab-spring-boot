package com.hvs.lab.user.models;

import lombok.Data;

@Data
public class Book {
    private long id;
    private long ISNB;
    private String titulo;
    private String descripcion;
}
