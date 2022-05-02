package edu.pl.mas.s19312.mp5.demo.model;

import edu.pl.mas.s19312.mp5.demo.repository.PersonRepository;
import edu.pl.mas.s19312.mp5.demo.repository.SGroupRepository;
import edu.pl.mas.s19312.mp5.demo.repository.StudentRepository;
import edu.pl.mas.s19312.mp5.demo.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AssociationTest {

    @Autowired
    SGroupRepository gRepository;

    @Autowired
    StudentRepository sRepository;


    @PersistenceContext
    private EntityManager em;

    SGroup group1;
    Student p1;

    @BeforeEach
    public void initialData(){
        Set<Double> grades = new HashSet<>();
        grades.add(5.);
        grades.add(4.);
        grades.add(2.);
        grades.add(3.5);
        p1 = Student.builder().firstName("John")
                .lastName("Smith")
                .passportNumber("FF125597JG").grades(grades).build();
        group1 = SGroup.builder().groupName("4f").build();
    }


    @Test
    public void testRequiredDependencies() {
        assertNotNull(sRepository);
        assertNotNull(gRepository);
    }

    @Test
    public void testSave(){
        group1.getMembers().add(p1);
        gRepository.save(group1);

        p1.setAssignedGroup(group1);
        sRepository.save(p1);

        System.out.println(p1.getId());
        Optional<SGroup> tmp = gRepository.findById(p1.getId());
        assertTrue(tmp.isPresent());
        System.out.println(tmp);
        assertEquals(1,tmp.get().getMembers().size());
    }

}