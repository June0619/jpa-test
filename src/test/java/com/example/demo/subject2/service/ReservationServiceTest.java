package com.example.demo.subject2.service;

import com.example.demo.subject2.domain.Member;
import com.example.demo.subject2.domain.Reservation;
import com.example.demo.subject2.domain.ReservationStatus;
import com.example.demo.subject2.repository.ReservationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ReservationServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationRepository reservationRepository;

    @Test
    @Transactional
    void makeReservation() {
        //given
        Member member = new Member("member");
        reservationService.makeReservation(member);

        //when
        Reservation reservation = reservationRepository.findOneByMemberId(member.getId());

        //then
        assertThat(reservation.getMember()).isEqualTo(member);
        assertThat(reservation.getStatus()).isEqualTo(ReservationStatus.USING);
    }

    @Test
    @Transactional
    void useEnd() {
        //given
        Member member = new Member("member");
        reservationService.makeReservation(member);

        Reservation reservation = reservationRepository.findOneByMemberId(member.getId());

        //when
        reservationService.useEnd(reservation.getId());

        //then
        assertThat(reservation.getStatus()).isEqualTo(ReservationStatus.CLOSED);
    }


}