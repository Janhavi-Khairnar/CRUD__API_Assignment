package com.example.crud_api.controller;


import com.example.crud_api.entity.CRUD_Entity;
import com.example.crud_api.model.CRUD_Model;
import com.example.crud_api.response.Response;
import com.example.crud_api.service.impl.CRUD_Service;
import jakarta.validation.Valid;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/crud")
public class CRUD_Controller {

    @Autowired
    CRUD_Service crud_service;


    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody @Valid CRUD_Model crud_model) {
        return new ResponseEntity<>(new Response("Data is added", HttpStatus.CREATED, crud_service.createAccount(crud_model)), HttpStatus.CREATED);
    }


    @GetMapping("/readInfo")
    public ResponseEntity<?> readInfo(){
        return new ResponseEntity<>(new Response("Data is display.", HttpStatus.OK, crud_service.readInfo()), HttpStatus.OK);
    }


    @GetMapping("/getProductById/{user_id}")
    public ResponseEntity<?> getProductById(@PathVariable("user_id") Integer user_id) {
        //return new ResponseEntity<>(crud_service.getProductById(user_id), HttpStatus.FOUND);
        return new ResponseEntity<>(new Response("Data is found by ID.", HttpStatus.OK, crud_service.getProductById(user_id)), HttpStatus.OK);
    }

    @GetMapping("/updateAccount/{user_id}")
    public  ResponseEntity<?> updateAccount(@PathVariable("user_id") Integer user_id, @RequestBody CRUD_Model crud_model) {
        return new ResponseEntity<>(new Response("Data is updated.", HttpStatus.ACCEPTED,crud_service.updateAccount(user_id, crud_model)), HttpStatus.OK);
    }

    @GetMapping("/deleteAccount/{user_id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("user_id") Integer user_id){
        return new ResponseEntity<>(new Response("Data is deleted.", HttpStatus.ACCEPTED, crud_service.deleteAccount(user_id)), HttpStatus.NO_CONTENT);
    }
}
