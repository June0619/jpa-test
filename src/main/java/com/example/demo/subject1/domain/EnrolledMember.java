package com.example.demo.subject1.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EnrolledMember {
    @EmbeddedId
    private EnrolledMemberCompositeId enrolledMemberCompositeId;

    //부가적인 필드들
}
