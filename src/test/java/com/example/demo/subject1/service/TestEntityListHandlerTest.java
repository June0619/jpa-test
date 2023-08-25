package com.example.demo.subject1.service;

import com.example.demo.subject1.domain.TestEntity;
import com.example.demo.subject1.service.TestEntityListHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class TestEntityListHandlerTest {

    @Autowired
    TestEntityListHandler testEntityListHandler;
    @Autowired EntityManager em;

    @Test
    void handle() {

        TestEntity testEntity = new TestEntity("test", 1.0);
        em.persist(testEntity);
        testEntityListHandler.handle();
        TestEntity result = em.find(TestEntity.class, 1L);

        assertThat(result.getStringField()).isEqualTo("updated");
    }

    @Test
    void handle_fail() {

        TestEntity entity1 = new TestEntity("test", 1.0);
        TestEntity entity2 = new TestEntity("test", 1.0);
        TestEntity entity3 = new TestEntity("test", 1.0);

        em.persist(entity1);
        em.persist(entity2);
        em.persist(entity3);

        testEntityListHandler.handle();
        TestEntity result1 = em.find(TestEntity.class, 1L);
        TestEntity result2 = em.find(TestEntity.class, 2L);
        TestEntity result3 = em.find(TestEntity.class, 3L);

        assertThat(result1.getStringField()).isEqualTo("updated");
        assertThat(result2.getStringField()).isEqualTo("failed");
        assertThat(result3.getStringField()).isEqualTo("updated");
    }

    @Test
    void handle2() {
        TestEntity testEntity = new TestEntity("test", 1.0);
        em.persist(testEntity);

        em.flush();
        em.clear();

        testEntityListHandler.handle2(1L);
        TestEntity result = em.find(TestEntity.class, 1L);

        assertThat(result.getStringField()).isEqualTo("failed");
    }
}