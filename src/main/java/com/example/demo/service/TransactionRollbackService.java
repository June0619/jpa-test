package com.example.demo.service;

import com.example.demo.domain.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional
public class TransactionRollbackService {

    private final TransactionRollbackChild transactionRollbackChild;
    private final EntityManager em;

    @Autowired
    public TransactionRollbackService(TransactionRollbackChild transactionRollbackChild, EntityManager em) {
        this.transactionRollbackChild = transactionRollbackChild;
        this.em = em;
    }

    public void required_rollback() {
        TestEntity testEntity = new TestEntity();
        testEntity.updateStringField("parent");

        em.persist(testEntity);

        transactionRollbackChild.rollback();
    }

    public void required_new_rollback() {
        TestEntity testEntity = new TestEntity();
        testEntity.updateStringField("parent");

        em.persist(testEntity);

        transactionRollbackChild.required_new_rollback();

        throw new RuntimeException("rollback");
    }

}
