package lab.aikibo.crudspringbootangular.services;

import lab.aikibo.crudspringbootangular.entity.User;

import java.util.List;

public interface UserServices {

    User findById(Long id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    void deleteAllUsers();

    List<User> findAllUsers();

    boolean isUserExist(User user);

}
