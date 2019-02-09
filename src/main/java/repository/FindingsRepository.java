package repository;

import model.entity.Animal;
import model.entity.Findings;
import model.entity.Users;
import model.entity.Visit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindingsRepository extends CrudRepository<Findings, Long> {

    @Query("select f from Findings f where f.visit in (?1)")
    public List<Findings> findByVisits(List<Visit> visit);

    @Query("select f from Findings f where f.visit = ?1")
    public List<Findings> findByVisits(Visit visit);
}
