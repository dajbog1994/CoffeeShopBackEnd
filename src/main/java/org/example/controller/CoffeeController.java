package org.example.controller;

import org.example.dto.CoffeDto;
import org.example.exception.CoffeNotFoundException;
import org.example.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoffeeController {


    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/coffee")
    public List<CoffeDto> displayCoffee(){
        List<CoffeDto> coffeeDtoList = coffeeService.getAllCoffee();
        return coffeeDtoList;
    }

    @GetMapping("/coffee/{id}")
    public ResponseEntity<CoffeDto> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(coffeeService.getCoffeeById(id), HttpStatus.OK);
        } catch (CoffeNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/coffee")
    public ResponseEntity<CoffeDto> save(@RequestBody CoffeDto coffeeDto){
        try {
            return new ResponseEntity<>(coffeeService.saveCoffee(coffeeDto), HttpStatus.OK);
        } catch ( CoffeNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }


    @PutMapping("/coffee")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CoffeDto> editCoffee(@RequestBody CoffeDto coffeeDto){
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(coffeeService.saveCoffee(coffeeDto), HttpStatus.OK);
        }catch (CoffeNotFoundException e){
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


    @DeleteMapping("/coffee/{id}")
    public ResponseEntity<CoffeDto> deleteCoffee(@PathVariable Long id){
        coffeeService.deleteCoffee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
