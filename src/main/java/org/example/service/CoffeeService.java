package org.example.service;

import org.example.dto.CoffeDto;
import org.example.exception.CoffeNotFoundException;
import org.example.mapp.CoffeMapper;
import org.example.model.Coffee;
import org.example.repository.CoffeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CoffeeService {

@Autowired
    private CoffeRepository coffeRepository;

@Autowired
    private CoffeMapper coffeMapper;


    public List<CoffeDto> getAllCoffee(){
        List<Coffee> result = coffeRepository.findAll();
        return result
                .stream()
                .map(coffee -> coffeMapper.coffeeToDto(coffee))
                .collect(Collectors.toList());
    }


    public CoffeDto getCoffeeById(Long id) throws CoffeNotFoundException {
        Coffee coffee = coffeRepository.findById(id).orElse(null);
        CoffeDto result;
        if(coffee != null) {
            result = coffeMapper.coffeeToDto(coffee);
        }else throw new CoffeNotFoundException();
        return result;
    }


    public CoffeDto saveCoffee(CoffeDto coffeDto) throws CoffeNotFoundException{
        if(coffeDto.getId() != null && coffeDto.getId() > 0
                && !coffeRepository.existsById(coffeDto.getId())){
            throw new CoffeNotFoundException();
        }
        Coffee coffee = coffeMapper.coffeeDtoToModel(coffeDto);
        coffee = coffeRepository.save(coffee);
        return  coffeMapper.coffeeToDto(coffee);
    }

    public void deleteCoffee(Long id){
        coffeRepository.deleteById(id);
    }

}
