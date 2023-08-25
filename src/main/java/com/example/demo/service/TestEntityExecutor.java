package com.example.demo.service;

import com.example.demo.domain.TestEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestEntityExecutor {

    @Transactional
    public void execute(TestEntity testEntity) {

        if (testEntity.getId() == 2L) {
            throw new RuntimeException("exception");
        }

        testEntity.updateStringField("updated");
    }
}
