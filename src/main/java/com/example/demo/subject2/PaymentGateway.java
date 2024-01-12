package com.example.demo.subject2;

import com.example.demo.subject2.v1.Transaction;

public class PaymentGateway {

    public boolean pay(Transaction transaction) {
        return false;
    }

    public boolean pay(com.example.demo.subject2.v2.Transaction transaction) {
        return false;
    }
}
