package com.example.demo.repository;

import com.example.demo.domain.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class TestEntityRepository {

    private final EntityManager em;

    @Autowired
    public TestEntityRepository(EntityManager em) {
        this.em = em;
    }

    public void save(TestEntity testEntity) {
        em.persist(testEntity);
    }

    public Optional<TestEntity> findById(long id) {
        TestEntity testEntity = em.find(TestEntity.class, id);
        return Optional.ofNullable(testEntity);
    }

    public List<TestEntity> getEntityList() {
        return em.createQuery("select t from TestEntity t", TestEntity.class)
                .getResultList();
    }
}
