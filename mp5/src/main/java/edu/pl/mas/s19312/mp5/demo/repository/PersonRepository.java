package edu.pl.mas.s19312.mp5.demo.repository;

import edu.pl.mas.s19312.mp5.demo.model.Person;
import edu.pl.mas.s19312.mp5.demo.model.SGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    public List<Person> findByFirstName(String firstName);
}
