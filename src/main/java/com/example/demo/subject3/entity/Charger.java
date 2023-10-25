package com.example.demo.subject3.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(ChargerId.class)
public class Charger {

    @Id
    @JoinColumn(name = "station_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Station station;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "charger_id")
    private long id;

    @Column(name = "name")
    private String name;

    protected Charger() {

    }

    public Charger(long id, Station station, String name) {
        this.id = id;
        this.station = station;
        this.name = name;
    }
}
