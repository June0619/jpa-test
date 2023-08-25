package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestEntitySub {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
}
