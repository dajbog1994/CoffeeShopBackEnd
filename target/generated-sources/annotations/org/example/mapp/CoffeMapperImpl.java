package org.example.mapp;

import javax.annotation.Generated;
import org.example.dto.CoffeDto;
import org.example.model.Coffee;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-31T13:22:35+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class CoffeMapperImpl implements CoffeMapper {

    @Override
    public Coffee coffeeDtoToModel(CoffeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Coffee coffee = new Coffee();

        coffee.setId( dto.getId() );
        coffee.setName( dto.getName() );
        coffee.setQuantity( dto.getQuantity() );
        coffee.setHasmilk( dto.getHasmilk() );
        coffee.setSugar( dto.isSugar() );
        coffee.setPrice( dto.getPrice() );

        return coffee;
    }

    @Override
    public CoffeDto coffeeToDto(Coffee model) {
        if ( model == null ) {
            return null;
        }

        CoffeDto coffeDto = new CoffeDto();

        coffeDto.setId( model.getId() );
        coffeDto.setName( model.getName() );
        coffeDto.setQuantity( model.getQuantity() );
        coffeDto.setHasmilk( model.getHasmilk() );
        coffeDto.setSugar( model.isSugar() );
        coffeDto.setPrice( model.getPrice() );

        return coffeDto;
    }
}
