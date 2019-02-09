package repository;

import model.entity.AnimalType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalTypeRepository extends CrudRepository<AnimalType, Long> {}
