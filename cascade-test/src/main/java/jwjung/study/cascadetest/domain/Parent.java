package jwjung.study.cascadetest.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @BatchSize(size = 100)
//    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
    private List<Child> childList = new ArrayList<>();

    public Parent() {
    }

    public Parent(final String name) {
        this.name = name;
    }
}
