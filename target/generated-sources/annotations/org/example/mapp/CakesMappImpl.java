package org.example.mapp;

import javax.annotation.Generated;
import org.example.dto.CakesDto;
import org.example.model.Cakes;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-02T10:29:35+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class CakesMappImpl implements CakesMapp {

    @Override
    public Cakes cakesDtoToModel(CakesDto dto) {
        if ( dto == null ) {
            return null;
        }

        Cakes cakes = new Cakes();

        cakes.setId( dto.getId() );
        cakes.setName( dto.getName() );
        cakes.setQuantity( dto.getQuantity() );
        cakes.setPrice( dto.getPrice() );

        return cakes;
    }

    @Override
    public CakesDto cakesToDto(Cakes model) {
        if ( model == null ) {
            return null;
        }

        CakesDto cakesDto = new CakesDto();

        cakesDto.setId( model.getId() );
        cakesDto.setName( model.getName() );
        cakesDto.setQuantity( model.getQuantity() );
        cakesDto.setPrice( model.getPrice() );

        return cakesDto;
    }
}
