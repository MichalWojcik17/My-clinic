package com.MichalWojcik.Clinic1.controller;

import com.MichalWojcik.Clinic1.model.Visit;
import com.MichalWojcik.Clinic1.repository.DoctorRepository;
import com.MichalWojcik.Clinic1.repository.PatientRepository;
import com.MichalWojcik.Clinic1.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VisitController {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
@Autowired
    private VisitRepository visitRepository;


    @GetMapping("/add/visits")
    public String add (ModelMap modelMap){
        modelMap.addAttribute("visit",new Visit());
        modelMap.addAttribute("doctors",doctorRepository.findAll());
        modelMap.addAttribute("patients",patientRepository.findAll());


        return "visits/add";

    } @PostMapping("/visits")
    public String save(@ModelAttribute Visit visit){
        visitRepository.save(visit);
        return "redirect:/visits";
    }

    @GetMapping("/visits")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("visits",visitRepository.findAll());
        return "visits/index";
    }

    @GetMapping("visits/{id}/edit")
    public String edit(@PathVariable Long id, ModelMap modelMap){
        modelMap.addAttribute("visit",visitRepository.findById(id).get());
        modelMap.addAttribute("doctors",doctorRepository.findAll());
        modelMap.addAttribute("patients",patientRepository.findAll());
        return "visits/add";
    }
    // redirect czyści parametry
    @GetMapping("visits/{id}/delete")
    public String delete(@PathVariable Long id){
        visitRepository.deleteById(id);
        return "redirect:/visits";
    }

}


