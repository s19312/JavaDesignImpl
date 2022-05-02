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

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonTest {
    
    @Autowired
    PersonRepository pRepository;

    @Autowired
    StudentRepository sRepository;

    @Autowired
    TeacherRepository tRepository;

    @PersistenceContext
    private EntityManager em;

    Teacher t1;
    Student s1;

    @BeforeEach
    public void initialData(){
        Set<Double> grades = new HashSet<>();
        grades.add(5.);
        grades.add(4.);
        grades.add(2.);
        grades.add(3.5);
        t1 = Teacher.builder().firstName("Jan").lastName("Koealski").passportNumber("FF764497GG").salary(3000).build();
        s1 = Student.builder().firstName("John")
                .lastName("Smith")
                .passportNumber("FF125597JG")
                .grades(grades).build();
    }


    @Test
    public void testRequiredDependencies() {
        assertNotNull(pRepository);
        assertNotNull(sRepository);
        assertNotNull(tRepository);
    }

    @Test public void testSaveAll(){

        int counter1 = (int) sRepository.count();
        int counter2 = (int) tRepository.count();
        int counter3 = (int) pRepository.count();
        assertEquals(1,counter1);
        assertEquals(1,counter2);
        assertEquals(2,counter3);
    }

    @Test
    public void testFindByFirstName(){
        sRepository.save(s1);
        tRepository.save(t1);
        List<Person> tmp = pRepository.findByFirstName("Jan");
        assertEquals(1,tmp.size());
    }


}