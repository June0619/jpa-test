package com.example.demo.subject3.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class ChargerId implements Serializable {

    @JoinColumn(name = "station_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Station station;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHARGER_SEQ_GENERATOR")
    @Column(name = "charger_id")
    private long id;
}
