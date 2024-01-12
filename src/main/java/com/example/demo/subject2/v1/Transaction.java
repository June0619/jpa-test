package com.example.demo.subject2.v1;

import lombok.Data;

@Data
public class Transaction {
    private long id;
    private long memberId;
    private String statusCode;
}
