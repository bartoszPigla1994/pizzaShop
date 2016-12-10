package com.pizzashop.controllers;

import com.pizzashop.models.Complaint;
import com.pizzashop.models.Pizza;
import com.pizzashop.repositories.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by barte on 10/12/2016.
 */
@RestController
@RequestMapping("/complaint")
public class ComplaintController {
    @Autowired
    ComplaintRepository complaintRepository;

    @RequestMapping("/read")
    public ResponseEntity<List<Complaint>> read(
            @RequestParam(value = "pageSize", required = true) Integer pageSize,
            @RequestParam(value = "pageNumber", required = true) Integer pageNumber){
        List<Complaint> complaintList=null;
        try{
            complaintList= complaintRepository
                    .findAll(new PageRequest((pageNumber == null) ? 0 : pageNumber - 1, pageSize))
                    .getContent();

            return new ResponseEntity<>(complaintList, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(complaintList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/count")
    public ResponseEntity<Integer> count(){
        int count=0;
        try{
            count=(int)complaintRepository.count();
            return new ResponseEntity<>(count, HttpStatus.OK);
        }
        catch (Exception exc){
            return new ResponseEntity<>(count, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
