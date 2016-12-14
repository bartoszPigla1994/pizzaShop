package com.pizzashop.controllers;

import com.pizzashop.models.Ingredient;
import com.pizzashop.models.Rebate;
import com.pizzashop.repositories.RebateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by barte on 14/12/2016.
 */
@RestController
@RequestMapping("/rebate")
public class RebateController {
    @Autowired
    RebateRepository rebateRepository;

    @RequestMapping("/read/all")
    public ResponseEntity<List<Rebate>> readAll(){
        List<Rebate> rebates=null;
        try{
            rebates = rebateRepository.findAll();
            return ResponseEntity.ok(rebates);
        }
        catch (Exception exception){
            return new ResponseEntity<List<Rebate>>(rebates, HttpStatus.NO_CONTENT);
        }
    }
}
