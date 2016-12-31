package com.pizzashop.controllers;

import com.pizzashop.models.Ingredient;
import com.pizzashop.models.Pizza;
import com.pizzashop.repositories.IngredientRepository;
import com.pizzashop.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by barte on 08/12/2016.
 */
@RestController
@RequestMapping("/pizza")
public class PizzaController {
    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    IngredientRepository ingredientRepository;

//    @Autowired
//    IngredientRepository ingredientRepository;


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<List<Pizza>> read(
            @RequestParam(value = "pageSize", required = true) Integer pageSize,
            @RequestParam(value = "pageNumber", required = true) Integer pageNumber
    ){
        List<Pizza> pizzaList=null;
        try{
            pizzaList= pizzaRepository
                    .findAll(new PageRequest((pageNumber == null) ? 0 : pageNumber - 1, pageSize))
                    .getContent();
            System.out.println(pizzaList);
            return new ResponseEntity<>(pizzaList, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(pizzaList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/read/{pizzaId}", method = RequestMethod.GET)
    public ResponseEntity<Pizza> read(@PathVariable Integer pizzaId){
        Pizza pizza=null;
        try{
            pizza= pizzaRepository.findOne(pizzaId);
            System.out.println(pizza);
            return new ResponseEntity<>(pizza, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(pizza, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{pizzaId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer pizzaId){
        try{
            pizzaRepository.delete(pizzaId);
            return ResponseEntity.noContent().build();
        }
        catch (Exception exception){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Pizza pizza){
        try{
            Pizza pizzaToUpdate=pizzaRepository.findOne(pizza.getProductId());
            if(pizzaToUpdate!=null)
                pizzaRepository.save(pizza);
            return ResponseEntity.noContent().build();

        }
        catch (Exception exception){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Pizza> create(@RequestBody Pizza pizza){
        try{
            Set<Ingredient> ingredients=new HashSet<>();
            for (Ingredient ingredient:pizza.getIngredients()) {
                Ingredient ingredientFromDb=ingredientRepository.findIngredientByName(ingredient.getName());
                ingredients.add(ingredientFromDb);
            }
            pizza.setIngredients(ingredients);

            pizzaRepository.save(pizza);
            return new ResponseEntity<>(pizza, HttpStatus.OK);
        }
        catch (Exception exc){
            return new ResponseEntity<>(pizza, HttpStatus.BAD_REQUEST);
        }
    }
}
