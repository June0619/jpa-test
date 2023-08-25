package com.example.demo.repository;

import com.example.demo.domain.TestEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class TestEntityRepositoryTest {

    @Autowired
    TestEntityRepository testEntityRepository;

    @Autowired
    EntityManager em;

    @Test
    void save() {
        //given
        TestEntity testEntity = new TestEntity("10", 10);
        //when
        testEntityRepository.save(testEntity);
        TestEntity result = em.find(TestEntity.class, testEntity.getId());

        Optional<TestEntity> result2 = testEntityRepository.findById(testEntity.getId());

        if (result2.isPresent()) {

        }

        System.out.println(result2.get() == result);
    }

}