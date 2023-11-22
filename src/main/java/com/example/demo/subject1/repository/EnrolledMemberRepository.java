package com.example.demo.subject1.repository;

import com.example.demo.subject1.domain.EnrolledMemberCompositeId;
import com.example.demo.subject1.domain.EnrolledMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EnrolledMemberRepository {

    private final EntityManager entityManager;

    public void save(EnrolledMember enrolledMember) {
        entityManager.persist(enrolledMember);
    }

    public Optional<EnrolledMember> findById(EnrolledMemberCompositeId id) {
        return Optional.ofNullable(entityManager.find(EnrolledMember.class, id));
    }

}
