package com.example.demo.subject3.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Station {

    @Id
    @GeneratedValue
    private long id;
}
