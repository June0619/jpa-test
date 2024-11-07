package com.example.demo.subject3;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;

@Service
public class MemberService {

    private final MemberRepository repository;
    private final PlatformTransactionManager ptm;

    public MemberService(MemberRepository repository, PlatformTransactionManager ptm) {
        this.repository = repository;
        this.ptm = ptm;
    }

    @PostConstruct
    public void init() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(ptm);
        transactionTemplate.execute(status -> {
            Member member = new Member(1L, "member1");
            repository.save(member);
            return null;
        });
    }

    @Transactional
    public void copyMember(long id) {
        Member member = repository.findById(id);
        repository.detach(member);

        member.copyMember();
        repository.save(member);
    }

}
