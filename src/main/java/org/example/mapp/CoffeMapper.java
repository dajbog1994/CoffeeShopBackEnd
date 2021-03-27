package org.example.mapp;

import org.example.dto.CoffeDto;
import org.example.model.Coffee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeMapper {

    Coffee coffeeDtoToModel(CoffeDto  dto);
    CoffeDto coffeeToDto (Coffee model);
}
