package lab.aikibo.repo;

import lab.aikibo.entity.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    List<AppUser> findAllByOrderById();
    Page<AppUser> findAllByOrderByIdAsc(Pageable pageable);

}
