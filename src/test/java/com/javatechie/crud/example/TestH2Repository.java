package com.javatechie.crud.example;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.crud.example.entity.Product;

public interface TestH2Repository extends JpaRepository<Product, Integer>{

}
