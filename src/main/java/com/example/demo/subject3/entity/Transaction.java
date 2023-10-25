package com.example.demo.subject3.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity @ToString
public class Transaction {

    @Id @Getter
    private long id;

    @JoinColumns({
            @JoinColumn(name = "station_id"),
            @JoinColumn(name = "charger_id")
    })
    @ManyToOne(fetch = FetchType.LAZY)
    private Charger charger;

    private String name;

    protected Transaction() {
    }

    public Transaction(Charger charger, String name) {
        this.charger = charger;
        this.name = name;
    }
}
