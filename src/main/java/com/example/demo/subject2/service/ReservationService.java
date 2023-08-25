package com.example.demo.subject2.service;

import com.example.demo.subject2.domain.Member;
import com.example.demo.subject2.domain.Reservation;
import com.example.demo.subject2.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {

    private final MockFeeService feeService;
    private final ReservationRepository reservationRepository;

    @Transactional
    public void makeReservation(Member member) {
        log.info("reservation: {}", member);
        Reservation reservation = new Reservation(member);
        reservationRepository.save(reservation);
    }

    @Transactional
    public void useEnd(long reservationId) {
        //get fee from external system
        long fee = feeService.getFee(reservationId);
        Reservation reservation = reservationRepository.findOne(reservationId);
        reservation.useEnd(fee);
    }




}
