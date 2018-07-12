package it.sky.dp.samplespringboot.repository;

import it.sky.dp.samplespringboot.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findById(Integer id);

}
