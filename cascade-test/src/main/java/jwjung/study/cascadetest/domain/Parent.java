package jwjung.study.cascadetest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Parent {

    @Id
    private Long id;

    @Column
    private String name;

}
