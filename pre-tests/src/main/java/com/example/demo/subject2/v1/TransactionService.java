package com.example.demo.subject2.v1;

import com.example.demo.subject2.PaymentGateway;

public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final MemberRepository memberRepository;
    private final PaymentGateway paymentGateway;

    public TransactionService(TransactionRepository transactionRepository, MemberRepository memberRepository,
            PaymentGateway paymentGateway) {
        this.transactionRepository = transactionRepository;
        this.memberRepository = memberRepository;
        this.paymentGateway = paymentGateway;
    }

    public void endTransaction(long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId);
        Member member = memberRepository.findById(transaction.getMemberId());

        boolean paymentResult = paymentGateway.pay(transaction);

        if (paymentResult) {
            transaction.setStatusCode("END");
        } else {
            transaction.setStatusCode("FAIL");
            member.setChargeable(false);

            memberRepository.update(member);
        }

        transactionRepository.update(transaction);
    }

}
