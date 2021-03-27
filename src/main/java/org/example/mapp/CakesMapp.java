package org.example.mapp;

import org.example.dto.CakesDto;
import org.example.model.Cakes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CakesMapp {
    Cakes cakesDtoToModel(CakesDto dto);
    CakesDto cakesToDto (Cakes model);
}
