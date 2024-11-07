package com.example.demo.subject3;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MEMBER")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    private long id;

    @Column(name = "NAME")
    private String name;

    public void copyMember() {
        this.id++;
        this.name = "copy_" + this.name;
    }
}
