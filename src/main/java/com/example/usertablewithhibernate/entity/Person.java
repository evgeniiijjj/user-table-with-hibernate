package com.example.usertablewithhibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "persons")
public final class Person {
    @EmbeddedId
    private PersonId id;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "city_of_living")
    private String city;
}
