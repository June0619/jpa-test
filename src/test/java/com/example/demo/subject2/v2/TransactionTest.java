package com.example.demo.subject2.v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class TransactionTest {

    @Test
    @DisplayName("Transaction 성공시 statusCode가 END로 변경되는지 확인")
    void transactionEndSuccess() {
        Transaction transaction = new Transaction();
        transaction.transactionEnd(true);

        assertThat(transaction.getStatusCode()).isEqualTo("END");
    }

    @Test
    @DisplayName("Transaction 실패시 statusCode가 FAIL로 변경되는지 확인")
    void transactionEndFail() {
        Transaction transaction = new Transaction();
        transaction.transactionEnd(false);

        assertThat(transaction.getStatusCode()).isEqualTo("FAIL");
    }

}