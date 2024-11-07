package com.example.demo.subject2.v2;

public class Member {
    private long id;
    public boolean isChargeable;

    public void failCharge() {
        isChargeable = false;
    }
}
