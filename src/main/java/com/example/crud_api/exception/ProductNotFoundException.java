package com.example.crud_api.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message) {

        super(message);
    }
}
