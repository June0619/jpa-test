package jwjung.study.cascadetest.jpa;

import jakarta.persistence.EntityManager;
import jwjung.study.cascadetest.domain.Child;
import jwjung.study.cascadetest.domain.Parent;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class CascadeTest {

    @Autowired
    EntityManager em;

    @BeforeEach
    @Transactional
    void setUp() {
        Parent parent = new Parent("parent");
        Child child = new Child(parent, "child");

        em.persist(parent);
        em.persist(child);

        em.flush();
        em.clear();
    }

    @Test
    @Transactional(readOnly = true)
    void select_test() {
        em.createQuery("select c from Child c", Child.class)
                .getResultList()
                .forEach(System.out::println);
    }

    @Test
    @Rollback(false)
    @Transactional
    void cascade() {
        Parent parent = em.find(Parent.class, 1L);

        em.remove(parent);

        List<Child> childList = em.createQuery("select c from Child c", Child.class)
                .getResultList();

        assertThat(childList).isEmpty();
    }

}
