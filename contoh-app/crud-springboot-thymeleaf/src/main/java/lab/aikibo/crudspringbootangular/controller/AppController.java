package lab.aikibo.crudspringbootangular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AppController {

    //@RequestMapping("/index")
    //public Map<String, Object> home(ModelMap modal) {
    //    Map<String, Object> hasil = new HashMap<>();
    //    hasil.put("title", "CRUD Example");
    //    return hasil;
    //}

    @RequestMapping("/halo")
    public Map<String, Object> halo(@RequestParam(name = "nama") String nama) {
        Map<String, Object> hasil = new HashMap<>();
        hasil.put("nama", nama);
        return hasil;
    }

    @RequestMapping("/halo2")
    public void halo2(@RequestParam(name = "nama")String nama, Model model) {
        model.addAttribute("nama", nama);
    }

    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }

}
