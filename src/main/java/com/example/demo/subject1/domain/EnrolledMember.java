package com.example.demo.subject1.domain;

import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "COMPOSITE_KEY_TEST")
@ToString
public class EnrolledMember {

    @EmbeddedId
    private EnrolledMemberCompositeId enrolledMemberCompositeId;

    protected EnrolledMember() {}

    public EnrolledMember(EnrolledMemberCompositeId enrolledMemberCompositeId) {
        this.enrolledMemberCompositeId = enrolledMemberCompositeId;
    }

    //부가적인 필드들
}
