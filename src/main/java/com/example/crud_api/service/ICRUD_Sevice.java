package com.example.crud_api.service;

import com.example.crud_api.entity.CRUD_Entity;
import com.example.crud_api.model.CRUD_Model;

import java.util.List;

public interface ICRUD_Sevice {

    public CRUD_Entity createAccount(CRUD_Model crud_model);
    public List<CRUD_Entity> readInfo();
    public String updateAccount(Integer user_id, CRUD_Model crud_model);
    public String deleteAccount(Integer user_id);
    public CRUD_Model getProductById(Integer user_id);

}
