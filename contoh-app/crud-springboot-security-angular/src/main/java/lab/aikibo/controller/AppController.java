package lab.aikibo.controller;

import lab.aikibo.entity.AppUser;
import lab.aikibo.repo.AppUserRepo;
import lab.aikibo.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AppController {

    @Autowired
    private AppUserRepo userRepo;

    @Autowired
    private AppUserService userService;

    @RequestMapping("/tester")
    public Map<String, Object> tester() {
        Map<String,Object> data = new HashMap<>();
        data.put("nama", "tamami");
        return data;
    }

    @RequestMapping("/tester2")
    public Map<String, Object> tester2(@RequestParam(name="nama",defaultValue = "tamami", required = false) String nama) {
        Map<String, Object> data = new HashMap<>();
        data.put("nama", nama);
        return data;
    }

    @RequestMapping("/tester3/{nama}")
    public Map<String, Object> tester3(@PathVariable("nama")String nama) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("nama", nama);
        return data;
    }

    // -- list daftar user

    @RequestMapping("/get-new-id")
    public Map<String, Object> getNewId() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", userRepo.count() + 1);
        return data;
    }

    @RequestMapping("/daftar-user")
    public List<AppUser> getAllUser() {
        return userRepo.findAllByOrderById();
    }

    @RequestMapping(value = "/get-user-by-id/{id}", method = RequestMethod.GET)
    public AppUser getUserById(@PathVariable("id") Long id) {
        return userRepo.findOne(id);
    }

    @RequestMapping("/daftar-user-paging")
    public Page<AppUser> getAllUserPaging(Pageable pageable) {
        return userRepo.findAllByOrderByIdAsc(pageable);
    }

    @RequestMapping(value = "/tambah-user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addData(@RequestBody AppUser user) {
        System.out.println(user.getId() + ":" + user.getName());
        userRepo.save(user);
    }

    @RequestMapping(value = "/tambah-user", method = RequestMethod.GET)
    public void addDataUI() {}

    @RequestMapping(value = "/update-user", method = RequestMethod.PUT)
    public void updateData(@RequestBody AppUser user) {
        userService.update(user);
    }

    @RequestMapping(value = "/get-detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<AppUser> getDetail(@PathVariable("id")Long id) {
        AppUser data = userRepo.findOne(id);

        if(data == null) {
            return new ResponseEntity<AppUser>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<AppUser>(data, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/hapus/{id}", method = RequestMethod.DELETE)
    public void deleteData(@PathVariable("id")Long id) {
        userRepo.delete(id);
    }

}
