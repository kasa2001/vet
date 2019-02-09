package repository;

import model.entity.Animal;
import model.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query("select a from Animal a where a.user = ?1")
    public List<Animal> findByUser(Users users);
}
