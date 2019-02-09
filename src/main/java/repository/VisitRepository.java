package repository;

import model.entity.Animal;
import model.entity.Users;
import model.entity.Visit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
    @Query("select v from Visit v where v.isFinished = false order by id")
    public List<Visit> findByNotFinished();

    @Query("select v from Visit v where v.users = ?1 order by id")
    public List<Visit> findByNotFinished(Users users);

    @Query("select v from Visit v where v.animal = ?1 order by id")
    public List<Visit> findByAnimal(Animal animal);
}