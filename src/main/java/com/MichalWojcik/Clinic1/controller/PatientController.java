package com.MichalWojcik.Clinic1.controller;

import com.MichalWojcik.Clinic1.model.Patient;
import com.MichalWojcik.Clinic1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/add/patients")
    public String add(ModelMap modelMap){
        modelMap.addAttribute("patient",new Patient());
        return "patients/add";
    }
    @PostMapping("/patients")
    public String save(@ModelAttribute Patient patient){
        patientRepository.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("patients",patientRepository.findAll());
        return "patients/index";
    }
    @GetMapping("patients/{id}/edit")
    public String edit(@PathVariable Long id, ModelMap modelMap){
        modelMap.addAttribute("patient",patientRepository.findById(id).get());
        return "patients/add";
    }
    // redirect czyści parametry
    @GetMapping("patients/{id}/delete")
    public String delete(@PathVariable Long id){
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }
    @GetMapping("/patients/{id}")
    public String details(@PathVariable Long id, ModelMap modelMap) {
        modelMap.put("patients", patientRepository.findById(id).get());

        return "patients/details";
    }
}
