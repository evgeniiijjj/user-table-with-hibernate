package com.example.usertablewithhibernate.controller;

import com.example.usertablewithhibernate.entity.Person;
import com.example.usertablewithhibernate.repository.MyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class MyController {
    private final MyRepository repository;

    public MyController(MyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return repository.findByCityEqualsIgnoreCase(city);
    }

    @GetMapping("/by-age")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return repository.findByIdAgeLessThanOrderByIdAge(age);
    }

    @GetMapping("/by-name-surname")
    public Person getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return repository.findByIdNameAndIdSurname(name, surname)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
