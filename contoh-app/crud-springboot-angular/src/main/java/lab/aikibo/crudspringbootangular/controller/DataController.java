package lab.aikibo.crudspringbootangular.controller;

import lab.aikibo.crudspringbootangular.entity.User;
import lab.aikibo.crudspringbootangular.repo.UserRepo;
import lab.aikibo.crudspringbootangular.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DataController {

    @Autowired
    private UserServicesImpl userServices;

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/daftar-user")
    public void daftarUser(Model model) {
        model.addAttribute("users", userServices.findAllUsers());
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userServices.deleteUserById(id);
        return "redirect:daftar-user";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public void getEditForm(@RequestParam(name = "id", required = false) Long id, Model model) {
        User result;

        if(id != null) {
            result = userServices.findById(id);
            System.out.println("result : " + result);
        } else {
            result = new User();
            System.out.println("result : " + result);
        }
        model.addAttribute("user", result);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String prosesEditForm(@ModelAttribute("user") User user, BindingResult errors) {
        if(errors.hasErrors()) {
            return "/edit";
        }

        System.out.println("isi dari form : " + user);
        Optional<User> cekUser = userRepo.findById(user.getId());
        System.out.println("cek user: " + cekUser);
        if(cekUser.isPresent()) userServices.updateUser(user);
        else userRepo.save(user);
        return "redirect:/daftar-user";
    }

    @RequestMapping(value = "/add-data", method = RequestMethod.GET)
    public String addData(User user) {
        user.setId(userRepo.count() + 1);
        return "edit";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public void getDetail(@RequestParam("id") Long id, Model model) {
        User result = userServices.findById(id);
        model.addAttribute("user", result);
    }

}
