package com.example.crud_api.repo;

import com.example.crud_api.entity.CRUD_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICRUD_Repo extends JpaRepository<CRUD_Entity, Integer> {
}
