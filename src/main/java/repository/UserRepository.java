package repository;

import model.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository <Users, Long>{

    @Query("select u from Users u where u.name = ?1 and u.password = ?2")
    public List<Users> checkSimple(String name, String password);
}
