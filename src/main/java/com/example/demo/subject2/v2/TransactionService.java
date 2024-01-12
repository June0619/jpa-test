package com.example.demo.subject2.v2;

import com.example.demo.subject2.PaymentGateway;

public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final PaymentGateway paymentGateway;

    public TransactionService(TransactionRepository transactionRepository, PaymentGateway paymentGateway) {
        this.transactionRepository = transactionRepository;
        this.paymentGateway = paymentGateway;
    }

    public void endTransaction(long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId);
        boolean isSuccess = paymentGateway.pay(transaction);

        transaction.transactionEnd(isSuccess);
    }
}
