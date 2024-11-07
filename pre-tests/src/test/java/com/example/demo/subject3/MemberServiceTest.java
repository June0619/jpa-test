package com.example.demo.subject3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    EntityManager em;

    @Test
    void copyMember() {
        memberService.copyMember(1);

        List<Member> findMembers = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        assertThat(findMembers.size()).isEqualTo(2);

        Member member = findMembers.get(1);

        System.out.println("findMembers = " + findMembers);


    }

}