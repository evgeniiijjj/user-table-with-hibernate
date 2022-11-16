package com.example.usertablewithhibernate.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MyRepository {
    @PersistenceContext
    private EntityManager manager;


    public List<String> getPersonsByCity(String city) {
        return manager.createQuery("select p.id.name from Person as p where lower(p.city) = lower(:city)", String.class)
                .setParameter("city", city).getResultList();
    }
}
