package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CoffeDto {

    private Long id;

    private String name;
    private int quantity;
    private String hasmilk;
    private boolean sugar;
    private int price;

}
