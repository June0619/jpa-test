package com.example.demo.subject3;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class MemberRepository {

    private final EntityManager em;

    public MemberRepository(EntityManager em) {
        this.em = em;
    }

    public void detach(Member member) {
        em.detach(member);
    }

    public void save(Member member) {
        em.persist(member);
    }

    public Member findById(long id) {
        return em.find(Member.class, id);
    }
}
