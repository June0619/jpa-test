package com.example.demo.subject2.controller;

import com.example.demo.subject2.domain.Member;
import com.example.demo.subject2.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public String makeReservation(@RequestBody String name) {
        reservationService.makeReservation(new Member(name));
        return "success";
    }

    @PostMapping("/useEnd")
    public String useEnd(@RequestBody long id) {
        reservationService.useEnd(id);
        return "success";
    }
}
