package com.pizzashop.controllers;

import com.pizzashop.models.Drink;
import com.pizzashop.models.Pizza;
import com.pizzashop.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by barte on 09/12/2016.
 */
@RestController
@RequestMapping("/drink")
public class DrinkController {
    @Autowired
    DrinkRepository drinkRepository;

//    @Autowired
//    IngredientRepository ingredientRepository;


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<List<Drink>> read(
            @RequestParam(value = "pageSize", required = true) Integer pageSize,
            @RequestParam(value = "pageNumber", required = true) Integer pageNumber
    ){
        List<Drink> drinkList=null;
        try{
            drinkList= drinkRepository
                    .findAll(new PageRequest(pageNumber, pageSize))
                    .getContent();

            return new ResponseEntity<>(drinkList, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(drinkList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/read/{drinkId}", method = RequestMethod.GET)
    public ResponseEntity<Drink> read(@PathVariable Integer drinkId){
        Drink drink=null;
        try{
            drink= drinkRepository.findOne(drinkId);
            return new ResponseEntity<>(drink, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(drink, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{drinkId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer drinkId){
        try{
            drinkRepository.delete(drinkId);
            return ResponseEntity.noContent().build();
        }
        catch (Exception exception){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Drink drink){
        try{
            Drink drinkToUpdate= drinkRepository.findOne(drink.getProductId());
            if(drinkToUpdate!=null)
                drinkRepository.save(drink);
            return ResponseEntity.noContent().build();

        }
        catch (Exception exception){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Drink> create(@RequestBody Drink drink){
        try{
            drinkRepository.save(drink);
            return new ResponseEntity<>(drink, HttpStatus.OK);
        }
        catch (Exception exc){
            return new ResponseEntity<>(drink, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}