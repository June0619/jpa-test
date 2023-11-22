package com.example.demo.subject1.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class EnrolledMemberCompositeId implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "ENTER_AT")
    private LocalDateTime enterAt;

    protected EnrolledMemberCompositeId() {}

    public EnrolledMemberCompositeId(String name, LocalDateTime enterAt) {
        this.name = name;
        this.enterAt = enterAt;
    }
}
