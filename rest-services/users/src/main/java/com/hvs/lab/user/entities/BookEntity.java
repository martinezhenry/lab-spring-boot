package com.hvs.lab.user.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private long ISNB;
    private String titulo;
    private String descripcion;
}
