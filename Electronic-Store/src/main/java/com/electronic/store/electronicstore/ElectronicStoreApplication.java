package com.electronic.store.electronicstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {
        "com.electronic.store.electronicstore.controllers",
        "com.electronic.store.electronicstore.service",
        "com.electronic.store.electronicstore.repository",
        "com.electronic.store.electronicstore.entity",
        "com.electronic.store.electronicstore.dtos",
        "com.electronic.store.electronicstore.exceptions",
        "com.electronic.store.electronicstore.enums",
        "com.electronic.store.electronicstore.helper"
})
@EntityScan(basePackages = "com.electronic.store.electronicstore.entity")
@EnableJpaRepositories(basePackages = "com.electronic.store.electronicstore.repository")
@SpringBootApplication
public class ElectronicStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElectronicStoreApplication.class, args);
    }
}
