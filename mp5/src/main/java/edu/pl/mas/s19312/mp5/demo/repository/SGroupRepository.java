package edu.pl.mas.s19312.mp5.demo.repository;

import edu.pl.mas.s19312.mp5.demo.model.SGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SGroupRepository extends CrudRepository<SGroup, Long> {
    public List<SGroup> findByGroupName(String groupName);

    @Query("from SGroup as g left join fetch g.members where g.id = :id")
    public Optional<SGroup> findById(@Param("id") Long id);
}
