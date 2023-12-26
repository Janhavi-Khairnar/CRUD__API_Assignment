package com.example.crud_api.service.impl;


import com.example.crud_api.entity.CRUD_Entity;
import com.example.crud_api.exception.ProductNotFoundException;
import com.example.crud_api.model.CRUD_Model;
import com.example.crud_api.repo.ICRUD_Repo;
import com.example.crud_api.service.ICRUD_Sevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CRUD_Service implements ICRUD_Sevice {

    @Autowired
    ICRUD_Repo icrud_repo;


    @Autowired
    ModelMapper modelMapper;

    @Override
    public CRUD_Entity createAccount(CRUD_Model crud_model) {
        CRUD_Entity crud_entity = new CRUD_Entity(crud_model);
        return icrud_repo.save(crud_entity);
    }

    @Override
    public List<CRUD_Entity> readInfo() {
        return icrud_repo.findAll();
    }

    @Override
    public String updateAccount(Integer user_id, CRUD_Model crud_model) {
        CRUD_Entity crud_entity = icrud_repo.findById(user_id).get();
        if (crud_entity != null) {
            crud_entity.setUser_name(crud_model.getUser_name());
            crud_entity.setUser_age(crud_model.getUser_age());
            crud_entity.setUser_hobbies(crud_model.getUser_hobbies());
            icrud_repo.save(crud_entity);
            return "Product is updated.";
        } else {
            return "Product is not available.";
        }
    }

    @Override
    public String deleteAccount(Integer user_id) {
        CRUD_Entity crud_entity = icrud_repo.findById(user_id).get();
        if (crud_entity != null) {
            icrud_repo.delete(crud_entity);
            return "Product is deleted.";
        } else {
            return "Product is not available.";
        }
    }

    @Override
    public CRUD_Model getProductById(Integer user_id) {
        CRUD_Entity crud_entity = icrud_repo.findById(user_id).orElseThrow(() -> new ProductNotFoundException("User is not found."));
        CRUD_Model crud_model = modelMapper.map(crud_entity, CRUD_Model.class);
        return crud_model;

//        Optional<CRUD_Entity> crud_entity = icrud_repo.findById(user_id);
//        if(crud_entity.isPresent()) {
//            CRUD_Model crud_model = modelMapper.map(crud_entity, CRUD_Model.class);
//            return crud_model;
//        }
//
//        throw new ProductNotFoundException("User is not found.");
    }
}

