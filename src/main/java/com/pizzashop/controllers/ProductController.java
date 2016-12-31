package com.pizzashop.controllers;

import com.pizzashop.models.Product;
import com.pizzashop.repositories.ProductBaseRepository;
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
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductBaseRepository productRepository;

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> read(
            @RequestParam(value = "pageSize", required = true) Integer pageSize,
            @RequestParam(value = "pageNumber", required = true) Integer pageNumber
    ){
        List<Product> productList=null;
        try{
            productList= productRepository
                    .findAll(new PageRequest(pageNumber, pageSize))
                    .getContent();

            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(productList, HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/read/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Product> read(@PathVariable Integer productId){
        Product product=null;
        try{
            product= (Product)productRepository.findOne(productId);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(product, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer productId){
        try{
            productRepository.delete(productId);
            return ResponseEntity.noContent().build();
        }
        catch (Exception exception){
            return ResponseEntity.notFound().build();
        }
    }
}
