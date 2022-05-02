package edu.pl.mas.s19312.mp5.demo.repository;

import edu.pl.mas.s19312.mp5.demo.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
