package com.example.demo.service;

import com.example.demo.domain.TestEntity;
import com.example.demo.repository.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TestEntityListHandler {

    private final TestEntityRepository testEntityRepository;
    private final TestEntityExecutor testEntityExecutor;

    @Autowired
    public TestEntityListHandler(TestEntityRepository testEntityRepository, TestEntityExecutor testEntityExecutor) {
        this.testEntityRepository = testEntityRepository;
        this.testEntityExecutor = testEntityExecutor;
    }

    public void handle() {
        List<TestEntity> entityList = testEntityRepository.getEntityList();
        for (TestEntity testEntity : entityList) {
            try {
                testEntityExecutor.execute(testEntity);
            } catch (RuntimeException e) {
                updateFailed(testEntity.getId());
            }
        }
    }

    public void handle2(long id) {
        try {
            throw new RuntimeException("exception");
        } catch (Exception e) {
            updateFailed(id);
        }
    }

    @Transactional
    public void updateFailed(long id) {
        Optional<TestEntity> result = testEntityRepository.findById(id);
        TestEntity testEntity = result.get();
        testEntity.updateStringField("failed");
    }

}
