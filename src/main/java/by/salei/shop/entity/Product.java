package by.salei.shop.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private Long id;
    private String name;
    private Long definition;
    private Long order;
}
