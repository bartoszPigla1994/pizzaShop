package com.pizzashop.controllers;

import com.pizzashop.models.Ingredient;
import com.pizzashop.models.Seasoning;
import com.pizzashop.repositories.SeasoningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by barte on 13/12/2016.
 */
@RestController
@RequestMapping("/seasoning")
public class SeasoningController {
    @Autowired
    SeasoningRepository seasoningRepository;

    @RequestMapping("/read/all")
    public ResponseEntity<List<Seasoning>> readAll(){
        List<Seasoning> seasonings=null;
        try{
            seasonings = seasoningRepository.findAll();
            return ResponseEntity.ok(seasonings);
        }
        catch (Exception exception){
            return new ResponseEntity<>(seasonings, HttpStatus.NO_CONTENT);
        }
    }
}
