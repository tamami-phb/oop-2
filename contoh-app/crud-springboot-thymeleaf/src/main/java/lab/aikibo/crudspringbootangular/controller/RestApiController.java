package lab.aikibo.crudspringbootangular.controller;

import lab.aikibo.crudspringbootangular.entity.User;
import lab.aikibo.crudspringbootangular.services.UserServices;
import lab.aikibo.crudspringbootangular.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    UserServices userServices;

    // -- get all user
    @RequestMapping(value="/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userServices.findAllUsers();
        if(users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    // -- get user by id
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        User user = userServices.findById(id);
        if(user == null) {
            return new ResponseEntity(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // -- add a user
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        if(userServices.isUserExist(user)) {
            return new ResponseEntity(new CustomErrorType("Unable to create. A user with name " + user.getName() +
                    "already exists."), HttpStatus.CONFLICT);
        }
        userServices.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // -- update a user
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User currentUser = userServices.findById(id);

        if(currentUser == null) {
            return new ResponseEntity(new CustomErrorType("Unable to update. User with id " + id +
                    " not found."), HttpStatus.NOT_FOUND);
        }

        currentUser.setName(user.getName());
        currentUser.setAge(user.getAge());
        currentUser.setSalary(user.getSalary());

        userServices.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    // -- Delete a user
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        User user = userServices.findById(id);
        if(user == null) {
            return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id +
                    " not found."), HttpStatus.NOT_FOUND);
        }
        userServices.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    // -- Delete all users
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        userServices.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
