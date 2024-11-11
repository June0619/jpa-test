package jwjung.study.cascadetest.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "parent")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "parent_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Parent parent;

    @Column
    private String name;

    public Child() {
    }

    public Child(final Parent parent, final String name) {
        this.parent = parent;
        this.name = name;
    }
}
