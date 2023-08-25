package com.example.demo.subject2.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
@ToString
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "FEE")
    private long fee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(name = "RESERVATION_STATUS")
    private ReservationStatus status;

    protected Reservation() {}

    public Reservation(Member member) {
        this.member = member;
        this.status = ReservationStatus.USING;
    }

    public void useStart() {
        this.status = ReservationStatus.USING;
    }

    public void useEnd(long fee) {
        this.fee = fee;
        this.status = ReservationStatus.CLOSED;
    }
}
