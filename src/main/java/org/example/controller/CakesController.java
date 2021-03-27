package org.example.controller;

import org.example.dto.CakesDto;
import org.example.exception.CakesException;
import org.example.service.CakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CakesController {


    @Autowired
    private CakesService cakesService;

    @GetMapping("/cakes")
    public List<CakesDto> displayCakes(){
        List<CakesDto> cakesDtoList = cakesService.getAllCakes();
        return cakesDtoList;
    }

    @GetMapping("/cakes/{id}")
    public ResponseEntity<CakesDto> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(cakesService.getCakesById(id), HttpStatus.OK);
        } catch (CakesException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/cakes")
    public ResponseEntity<CakesDto> save(@RequestBody CakesDto cakesDto){
        try {
            return new ResponseEntity<>(cakesService.saveCakes(cakesDto), HttpStatus.OK);
        } catch ( CakesException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }


    @PutMapping("/cakes")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CakesDto> editCakes(@RequestBody CakesDto cakesDto){
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(cakesService.saveCakes(cakesDto), HttpStatus.OK);
        }catch (CakesException e){
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


    @DeleteMapping("/cakes/{id}")
    public ResponseEntity<CakesDto> deleteCakes(@PathVariable Long id){
        cakesService.deleteCakes(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

