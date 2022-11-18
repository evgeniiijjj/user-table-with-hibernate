package com.example.usertablewithhibernate.repository;

import com.example.usertablewithhibernate.entity.Person;
import com.example.usertablewithhibernate.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyRepository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityEqualsIgnoreCase(String city);
    List<Person> findByIdAgeLessThanOrderByIdAge(int age);
    Optional<Person> findByIdNameAndIdSurname(String name, String surname);
}
