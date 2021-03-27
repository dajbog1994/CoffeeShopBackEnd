package org.example.service;

import org.example.dto.CakesDto;
import org.example.exception.CakesException;
import org.example.mapp.CakesMapp;
import org.example.model.Cakes;
import org.example.repository.CakesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CakesService {

    @Autowired
    private CakesRepository cakesRepository;

    @Autowired
    private CakesMapp cakesMapp;


    public List<CakesDto> getAllCakes(){
        List<Cakes> result = cakesRepository.findAll();
        return result
                .stream()
                .map(cakes -> cakesMapp.cakesToDto(cakes))
                .collect(Collectors.toList());
    }


    public CakesDto getCakesById(Long id) throws CakesException {
        Cakes cakes = cakesRepository.findById(id).orElse(null);
        CakesDto result;
        if(cakes != null) {
            result = cakesMapp.cakesToDto(cakes);
        }else throw new CakesException();
        return result;
    }


    public CakesDto saveCakes(CakesDto cakesDto) throws CakesException{
        if(cakesDto.getId() != null && cakesDto.getId() > 0
                && !cakesRepository.existsById(cakesDto.getId())){
            throw new CakesException();
        }
        Cakes cakes= cakesMapp.cakesDtoToModel(cakesDto);
        cakes = cakesRepository.save(cakes);
        return  cakesMapp.cakesToDto(cakes);
    }

    public void deleteCakes(Long id){
        cakesRepository.deleteById(id);
    }

}
