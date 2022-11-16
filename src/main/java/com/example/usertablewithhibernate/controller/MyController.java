package com.example.usertablewithhibernate.controller;

import com.example.usertablewithhibernate.repository.MyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    private final MyRepository repository;

    public MyController(MyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<String> getProductName(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }
}
