package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.model.mahasiswaModel;
import com.example.service.mahasiswaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class mahasiswaController
{
    @Autowired
    mahasiswaService mahasiswaDAO;


    @RequestMapping("/")
    public String index ()
    {
        return "index";
    }


    @RequestMapping("/mahasiswa/add")
    public String add ()
    {
        return "form-add";
    }


    @RequestMapping("/mahasiswa/add/submit")
    public String addSubmit (
            @RequestParam(value = "npm", required = false) String npm,
            @RequestParam(value = "nama", required = false) String nama,
            @RequestParam(value = "agama", required = false) String agama)
    {
        mahasiswaModel mahasiswa = new mahasiswaModel (npm, nama, agama);
        mahasiswaDAO.addmahasiswa (mahasiswa);

        return "success-add";
    }


    @RequestMapping("/mahasiswa/view")
    public String view (Model model,
            @RequestParam(value = "npm", required = false) String npm)
    {
        mahasiswaModel mahasiswa = mahasiswaDAO.selectmahasiswa (npm);

        if (mahasiswa != null) {
            model.addAttribute ("mahasiswa", mahasiswa);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }


    @RequestMapping("/mahasiswa/view/{npm}")
    public String viewPath (Model model,
            @PathVariable(value = "npm") String npm)
    {
        mahasiswaModel mahasiswa = mahasiswaDAO.selectmahasiswa (npm);

        if (mahasiswa != null) {
            model.addAttribute ("mahasiswa", mahasiswa);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }


    @RequestMapping("/mahasiswa/viewall")
    public String viewAll (Model model)
    {
        List<mahasiswaModel> mahasiswas = mahasiswaDAO.selectAllmahasiswas ();
        model.addAttribute ("mahasiswas", mahasiswas);
        
        log.info(mahasiswas.toString());
        
        return "viewall";
    }


    @RequestMapping("/mahasiswa/delete/{npm}")
    public String delete (Model model, @PathVariable(value = "npm") String npm)
    {
    	mahasiswaModel mahasiswa = mahasiswaDAO.selectmahasiswa (npm);

        if (mahasiswa != null) {
        	mahasiswaDAO.deletemahasiswa (npm);
            model.addAttribute ("mahasiswa", mahasiswa);
            return "delete";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
  
    }
    
    @RequestMapping("/mahasiswa/update/{npm}")
    public String update (Model model, @PathVariable(value = "npm") String npm)
    {
    	mahasiswaModel mahasiswa = mahasiswaDAO.selectmahasiswa (npm);

        if (mahasiswa != null) {
            model.addAttribute ("mahasiswa", mahasiswa);
            return "form-update";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }
    
    /*@RequestMapping(value = "/mahasiswa/update/submit", method = RequestMethod.POST)
    public String updateSubmit (
            @RequestParam(value = "npm", required = false) String npm,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "agama", required = false) double agama)
    {
    	
        mahasiswaModel mahasiswa = new mahasiswaModel (npm, name, agama);
        mahasiswaDAO.updatemahasiswa(mahasiswa);

        return "success-update";
    }*/
    
    @RequestMapping(value = "/mahasiswa/update/submit", method = RequestMethod.POST)
    public String updateSubmit (
            @ModelAttribute mahasiswaModel mahasiswa)
    {
        mahasiswaDAO.updatemahasiswa(mahasiswa);

        return "success-update";
    }

}
