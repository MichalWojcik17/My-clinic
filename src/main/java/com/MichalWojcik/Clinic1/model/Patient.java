package com.MichalWojcik.Clinic1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
  private String name,surname,healthInsurance;
  private int age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean insured;
    public boolean isInsured() {
        return insured;
    }

    public String healthInsurance(){
        return isInsured() ? "Insured " : "Uninsured";
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public Patient(String name, String surname, String healthInsurance, int age) {
        this.name = name;
        this.surname = surname;
        this.healthInsurance = healthInsurance;
        this.age = age;
    }

    public Patient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String fullNamePatient(){
        return getName()+" "+getSurname();
    }
}
