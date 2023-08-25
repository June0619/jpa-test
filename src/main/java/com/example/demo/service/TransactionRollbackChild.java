package com.example.demo.service;

import com.example.demo.domain.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class TransactionRollbackChild {

    @Autowired
    EntityManager em;

    @Transactional
    public void rollback() {

        TestEntity testEntity = new TestEntity();
        testEntity.updateStringField("child");

        em.persist(testEntity);

        System.out.println("rollback");

        throw new RuntimeException("rollback");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void required_new_rollback() {

        TestEntity testEntity = new TestEntity();
        testEntity.updateStringField("child");

        em.persist(testEntity);

        System.out.println("child committed");
    }

}
