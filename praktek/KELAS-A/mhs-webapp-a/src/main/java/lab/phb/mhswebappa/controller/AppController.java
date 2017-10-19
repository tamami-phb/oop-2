package lab.phb.mhswebappa.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    
    @RequestMapping("/home")
    public Map<String, Object> index(
            @RequestParam("nama")String nama) {
        Map<String, Object> hasil = new HashMap<>();
        hasil.put("nama", nama);
        hasil.put("jurusan", "Teknik Informatika");
        hasil.put("angkatan", 2002);
        return hasil;
    }
    
    @RequestMapping("/index")
    public void home() {}
    
}
