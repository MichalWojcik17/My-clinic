package com.MichalWojcik.Clinic1.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Visit {

    @OneToOne(cascade = CascadeType.ALL)
    private Doctor doctor;
    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfTheVisit;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Visit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visit(Doctor doctor, Patient patient,LocalDate dateOfTheVisit) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateOfTheVisit = dateOfTheVisit;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDateOfTheVisit() {
        return dateOfTheVisit;
    }

    public void setDateOfTheVisit(LocalDate dateOfTheVisit) {
        this.dateOfTheVisit = dateOfTheVisit;
    }

    @Override
    public String toString() {
        return dateOfTheVisit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


}