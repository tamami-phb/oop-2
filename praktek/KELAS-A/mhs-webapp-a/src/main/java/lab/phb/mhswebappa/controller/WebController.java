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
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping("/hapus")
    public String hapusData(@RequestParam("nim") String nim) {
        mhsRepo.delete(nim);
        return "redirect:daftar-mahasiswa";
    }
    
    @RequestMapping(value = "/ubah-data", method = RequestMethod.GET)
    public void getUbahData(@RequestParam("nim") String nim, 
            Model model) {
        Mahasiswa data = mhsRepo.findOne(nim);
        model.addAttribute("mhs", data);
    }
    
    @RequestMapping(value = "/ubah-data", method = RequestMethod.POST)
    public String saveUbahData(@ModelAttribute("mhs") Mahasiswa mhs,
            BindingResult result) {
        System.out.println("nim: " + mhs.getNim());
        System.out.println("nama: " + mhs.getNama());
        System.out.println("jurusan: " + mhs.getJurusan());
        mhsRepo.save(mhs);
        return "redirect:daftar-mahasiswa";
    }
    
}
