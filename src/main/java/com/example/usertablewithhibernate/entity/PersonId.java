package com.example.usertablewithhibernate.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class PersonId implements Serializable {
    private static final long serialVersionUID = 5355048285684721165L;
    private String name;
    private String surname;
    private int age;
}
