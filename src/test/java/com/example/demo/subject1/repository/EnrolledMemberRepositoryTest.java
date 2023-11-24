package com.example.demo.subject1.repository;

import com.example.demo.subject1.domain.EnrolledMember;
import com.example.demo.subject1.domain.EnrolledMemberCompositeId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class EnrolledMemberRepositoryTest {

    @Autowired
    EntityManager entityManager;
    @Autowired
    EnrolledMemberRepository enrolledMemberRepository;

    @Test
    void findById() {
        //given
        EnrolledMemberCompositeId memberId = new EnrolledMemberCompositeId("MEMBER", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        EnrolledMember member = new EnrolledMember(memberId);
        entityManager.persist(member);

        entityManager.flush();
        entityManager.clear();

        //when
        Optional<EnrolledMember> optionalEnrolledMember = enrolledMemberRepository.findById(memberId);

        //then
        assertThat(optionalEnrolledMember).isNotEmpty();
    }
}