package com.example.crud_api.entity;

import com.example.crud_api.model.CRUD_Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "crud_table")
public class CRUD_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer user_id;

    @NotBlank(message = "Please enter the name.")
    private String user_name;

    @NotBlank(message = "Please enter the age.")
    private Integer user_age;

    @NotBlank(message = "Please enter the hobbies.")
    private String user_hobbies;


    public CRUD_Entity(CRUD_Model crud_model) {
        this.user_name =crud_model.getUser_name();
        this.user_age = crud_model.getUser_age();
        this.user_hobbies = crud_model.getUser_hobbies();
    }
}
