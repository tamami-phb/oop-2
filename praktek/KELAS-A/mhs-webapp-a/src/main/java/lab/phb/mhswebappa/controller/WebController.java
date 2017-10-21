package lab.phb.mhswebappa.controller;

import lab.phb.mhswebappa.entity.Mahasiswa;
import lab.phb.mhswebappa.repo.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author tamami <tamami.oka@gmail.com>
 */
@Controller
public class WebController {
    
    @Autowired
    private MahasiswaRepo mhsRepo;
    
    @RequestMapping("/daftar-mahasiswa")
    public void daftarMahasiswa(Model model) {
        model.addAttribute("daftarMahasiswa", 
                mhsRepo.findAll());
    }
    
    @RequestMapping(value = "/tambah-data", method = RequestMethod.GET)
    public void addData(@ModelAttribute("mhs") Mahasiswa mhs, 
            BindingResult bind) {}
    
    @RequestMapping(value = "/tambah-data", method = RequestMethod.POST)
    public void addDataProcessing(@ModelAttribute("mhs") Mahasiswa mhs, 
            BindingResult bind) {
        System.out.println(mhs.getNim());
        System.out.println(mhs.getNama());
        System.out.println(mhs.getJurusan());
        
        // proses simpan data
        mhsRepo.save(mhs);
    }
    
}
