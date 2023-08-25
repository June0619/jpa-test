package com.example.demo.subject2.repository;

import com.example.demo.subject2.domain.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReservationRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Reservation reservation) {
        em.persist(reservation);
    }

    public Reservation findOne(Long id) {
        return em.find(Reservation.class, id);
    }

    public Reservation findOneByMemberId(Long memberId) {
        return em.createQuery("select r from Reservation r where r.member.id = :memberId", Reservation.class)
                .setParameter("memberId", memberId)
                .getSingleResult();
    }

}
