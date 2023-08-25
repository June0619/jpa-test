package com.example.demo.subject2.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestDataInit {

    @PersistenceContext
    private EntityManager em;
    private final PlatformTransactionManager transactionManager;

    @PostConstruct
    public void init() {

        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(status -> {
            for (int i = 0; i < 50; i++) {
                Member member = new Member("member" + i);
                Reservation reservation = new Reservation(member);
                em.persist(reservation);
            }
            return null;
        });
    }
}
