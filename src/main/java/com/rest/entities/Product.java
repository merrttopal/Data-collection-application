package com.rest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String title;


    @Size(min = 5, max = 500)
    @NotEmpty
    @NotNull
    private String detail;


    @NotNull
    @PositiveOrZero
    private Integer price;


    @NotNull
    private Boolean status;

}
