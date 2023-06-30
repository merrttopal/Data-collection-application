package com.rest.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Plant {
    private String common;
    private String botanical;
    private String light;
    private String price;

}
