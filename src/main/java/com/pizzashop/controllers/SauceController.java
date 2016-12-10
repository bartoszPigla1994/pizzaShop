package com.pizzashop.controllers;

import com.pizzashop.models.Pizza;
import com.pizzashop.models.Sauce;
import com.pizzashop.repositories.SauceRepository;
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
@RequestMapping("/sauce")
public class SauceController {
    @Autowired
    SauceRepository sauceRepository;


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<List<Sauce>> read(
            @RequestParam(value = "pageSize", required = true) Integer pageSize,
            @RequestParam(value = "pageNumber", required = true) Integer pageNumber
    ){
        List<Sauce> sauceList=null;
        try{
            sauceList= sauceRepository
                    .findAll(new PageRequest(pageNumber, pageSize))
                    .getContent();

            return new ResponseEntity<>(sauceList, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(sauceList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/read/{sauceId}", method = RequestMethod.GET)
    public ResponseEntity<Sauce> read(@PathVariable Integer sauceId){
        Sauce sauce=null;
        try{
            sauce= sauceRepository.findOne(sauceId);
            return new ResponseEntity<>(sauce, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(sauce, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{sauceId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer sauceId){
        try{
            sauceRepository.delete(sauceId);
            return ResponseEntity.noContent().build();
        }
        catch (Exception exception){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Sauce sauce){
        try{
            Sauce sauceToUpdate=sauceRepository.findOne(sauce.getProductId());
            if(sauceToUpdate!=null)
                sauceRepository.save(sauce);
            return ResponseEntity.noContent().build();

        }
        catch (Exception exception){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Sauce> create(@RequestBody Sauce sauce){
        try{
            sauceRepository.save(sauce);
            return new ResponseEntity<Sauce>(sauce, HttpStatus.OK);
        }
        catch (Exception exc){
            return new ResponseEntity<Sauce>(sauce, HttpStatus.INTERNAL_SERVER_ERROR);
        }

//        ingredientRepository.save(i1);
//        ingredientRepository.save(i2);
//
//        drinkRepository.save(p);
//
//        return p;
    }
}
