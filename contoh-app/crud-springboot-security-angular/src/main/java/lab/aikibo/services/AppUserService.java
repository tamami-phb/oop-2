package lab.aikibo.services;

import lab.aikibo.entity.AppUser;
import lab.aikibo.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AppUserService {

    @Autowired
    private AppUserRepo userRepo;

    public void update(AppUser user) {
        AppUser data = userRepo.getOne(user.getId());
        data.setName(user.getName());
        data.setAge(user.getAge());
        data.setSalary(user.getSalary());
        userRepo.save(data);
    }

}
