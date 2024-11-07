package jwjung.study.cascadetest.domain;

import jakarta.persistence.*;

@Entity
public class Child {


    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Parent parent;

    @Column
    private String name;

}
