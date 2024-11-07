package com.example.demo.subject2.v2;

import lombok.Getter;

@Getter
public class Transaction {
    private long id;
    private Member member;
    private String statusCode;

    public void transactionEnd(boolean paymentResult) {
        if (paymentResult) {
            statusCode = "END";
        } else {
            statusCode = "FAIL";
            member.failCharge();
        }
    }
}
