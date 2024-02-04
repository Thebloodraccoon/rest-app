package org.hillel.rest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hillel.rest.model.Product;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
@Builder
public class OrderDTO {
    private Integer id;
    private LocalDate date;
    private double cost;
    private List<Product> products;
}
