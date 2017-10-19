package lab.aikibo.crudspringbootangular.repo;

import lab.aikibo.crudspringbootangular.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);
    User findByName(String name);
    List<User> findAllByOrderByIdAsc();

}
