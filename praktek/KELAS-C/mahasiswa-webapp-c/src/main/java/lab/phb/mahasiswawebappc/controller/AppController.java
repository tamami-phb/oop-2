package lab.phb.mahasiswawebappc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import lab.phb.mahasiswawebappc.repo.MahasiswaRepo;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import lab.phb.mahasiswawebappc.entity.Mahasiswa;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    
    @Autowired
    private MahasiswaRepo mhsRepo;
    
    @RequestMapping("/home")
    public void index() {}
    
    @RequestMapping("/daftar-mahasiswa")
    public void getDaftarMahasiswa(Model model) {
        model.addAttribute("daftarMahasiswa", 
                mhsRepo.findAll());
    }

    @RequestMapping(value = "/tambah-data", 
    	method = RequestMethod.GET)
    public void getFormTambahData(
    	@ModelAttribute("mhs") Mahasiswa mhs, 
    	BindingResult result) {}

    @RequestMapping(value = "/tambah-data", 
    	method = RequestMethod.POST)
    public String simpanData(
    		@ModelAttribute("mhs") Mahasiswa mhs,
    		BindingResult result) {
    	System.out.println("nim : " + mhs.getNim());
    	System.out.println("nama : " + mhs.getNama());
    	System.out.println("jurusan : " + mhs.getJurusan());
    	mhsRepo.save(mhs);
    	return "redirect:daftar-mahasiswa";
    }
    
}
