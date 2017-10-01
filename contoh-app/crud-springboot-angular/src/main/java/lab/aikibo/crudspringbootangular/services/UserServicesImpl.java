package lab.aikibo.crudspringbootangular.services;

import lab.aikibo.crudspringbootangular.entity.User;
import lab.aikibo.crudspringbootangular.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User findById(Long id) {
        return userRepo.findOne(id);
    }

    @Override
    public User findByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void updateUser(User user) {
        User data = userRepo.getOne(user.getId());
        data.setName(user.getName());
        data.setAge(user.getAge());
        data.setSalary(user.getSalary());
        userRepo.save(data);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepo.delete(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepo.deleteAll();
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAllByOrderByIdAsc();
    }

    @Override
    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
    }
}
