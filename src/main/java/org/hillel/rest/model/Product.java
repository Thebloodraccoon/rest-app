package org.hillel.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Product {
    private Integer id;
    private String name;
    private double cost;
}
