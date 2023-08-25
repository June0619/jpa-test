package com.example.demo.subject2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MockFeeService {

    public long getFee(long reservationId) {
        try {
            long timeAndFee = (long) (Math.random() * 1000);
            Thread.sleep(timeAndFee);

            log.info("getFee: {}", timeAndFee);

            return timeAndFee;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
