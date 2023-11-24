package com.example.demo.subject1.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@ToString
@Getter
public class EnrolledMemberCompositeId implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Convert(converter = DateToStringConverter.class)
    @Column(name = "ENTERED_AT")
    private String enterAt;

    protected EnrolledMemberCompositeId() {}

    public EnrolledMemberCompositeId(String name, String enterAt) {
        this.name = name;
        this.enterAt = enterAt;
    }
}
