package com.example.usertablewithhibernate.repository;

import com.example.usertablewithhibernate.entity.Person;
import com.example.usertablewithhibernate.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyRepository extends JpaRepository<Person, PersonId> {
    @Query("select p from Person as p where p.city = :city")
    List<Person> findByCity(@Param("city") String city);
    @Query("select p from Person as p where p.id.age < :age order by p.id.age")
    List<Person> findByIdAgeLessThanOrderByIdAge(@Param("age") int age);
    @Query("select p from Person as p where p.id.name = :name and p.id.surname = :surname")
    Optional<Person> findByIdNameAndIdSurname(@Param("name") String name, @Param("surname") String surname);
}
