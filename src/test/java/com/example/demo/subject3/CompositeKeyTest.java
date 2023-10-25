package com.example.demo.subject3;

import com.example.demo.subject3.entity.Charger;
import com.example.demo.subject3.entity.Station;
import com.example.demo.subject3.entity.Transaction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@SpringBootTest
class CompositeKeyTest {

    @Autowired
    EntityManager em;

    @Test
    void save() {

        Station station = new Station();
        Charger charger = new Charger(1L, station, "charger1");

        em.persist(station);
        em.persist(charger);
    }

    @Test
    void select() {

        Station station = new Station();
        Charger charger = new Charger(1L, station, "charger1");

        em.persist(station);
        em.persist(charger);

        Transaction transaction = new Transaction(charger, "transaction1");
        em.persist(transaction);

        em.flush();
        em.clear();

        Transaction findTransaction = em.find(Transaction.class, transaction.getId());
        System.out.println("findTransaction = " + findTransaction);
    }



}