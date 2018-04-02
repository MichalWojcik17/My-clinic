package com.MichalWojcik.Clinic1.controller;

import com.MichalWojcik.Clinic1.model.Doctor;
import com.MichalWojcik.Clinic1.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/add/doctors")
        public String add (ModelMap modelMap){
        modelMap.addAttribute("doctor",new Doctor());
        return "doctors/add";

    } @PostMapping("/doctors")
    public String save(@ModelAttribute Doctor doctor){
      doctorRepository.save(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("doctors",doctorRepository.findAll());
        return "doctors/index";
        }

        @GetMapping("doctors/{id}/edit")
    public String edit(@PathVariable Long id, ModelMap modelMap){
        modelMap.addAttribute("doctor",doctorRepository.findById(id).get());
        return "doctors/add";
    }
    // redirect czyści parametry
    @GetMapping("doctors/{id}/delete")
    public String delete(@PathVariable Long id){
        doctorRepository.deleteById(id);
        return "redirect:/doctors";
    }
    @GetMapping("/doctors/{id}")
    public String details(@PathVariable Long id, ModelMap modelMap) {
        modelMap.put("doctors", doctorRepository.findById(id).get());

        return "doctors/details";
    }
}
