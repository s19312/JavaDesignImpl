package edu.pl.mas.s19312.mp5.demo.model;

import edu.pl.mas.s19312.mp5.demo.repository.SGroupRepository;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SGroupTest {

    SGroup sg1;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private SGroupRepository sGroupRepository;

    @BeforeEach
    public void initialData(){
        sg1 = SGroup.builder().groupName("2a").build();
    }

    @Test
    public void testRequiredDependencies() {
        assertNotNull(sGroupRepository);
    }


    @Test
    public void testFetchSGroup() {
        Iterable<SGroup> allsg = sGroupRepository.findAll();
        for(SGroup sg : allsg){
            System.out.println(sg);
        }
    }

    @Test public void testSaveSGroup(){
        sGroupRepository.save(sg1);
        int counter = (int) sGroupRepository.count();
        assertEquals(1,counter);
    }
    @Test
    public void testSaveInvalidSGroupName(){
        assertThrows(ConstraintViolationException.class, () -> {
            SGroup sg2 = SGroup.builder().groupName("").build();
            sGroupRepository.save(sg2);
            em.flush();
        });
    }

    @Test
    public void testFindByGroupName(){
        sGroupRepository.save(sg1);
        List<SGroup> tmp = sGroupRepository.findByGroupName("2a");
        assertEquals(1,tmp.size());
    }
}