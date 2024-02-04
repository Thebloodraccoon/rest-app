package org.hillel.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@ToString
@Builder
public class Order {
    private Integer id;
    private LocalDate date;
    private double cost;
    private List<Product> products;
}
