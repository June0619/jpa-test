package com.example.demo.subject1.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TestEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "STRING_FIELD_2", length = 100)
    private String stringField;

    //varchar2 to LocalDateTime
    @Convert(converter = CustomStringConverter.class)
    @Column(name = "TEST_DATE")
    private LocalDateTime testDate;

    @Column(name = "DOUBLE_FIELD")
    private double doubleField;

    @JoinColumn(name = "TEST_ENTITY_SUB_ID")
    @OneToOne(cascade = CascadeType.ALL)
    private TestEntitySub testEntitySub;

    public long getId() {
        return id;
    }

    public String getStringField() {
        return stringField;
    }

    public double getDoubleField() {
        return doubleField;
    }

    public TestEntity() {

    }

    public void updateStringField(String stringField) {
        this.stringField = stringField;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", stringField='" + stringField + '\'' +
                ", testDate=" + testDate +
                ", doubleField=" + doubleField +
                '}';
    }

    public TestEntity(String stringField, double doubleField) {
        this.stringField = stringField;
        this.doubleField = doubleField;
    }

}
