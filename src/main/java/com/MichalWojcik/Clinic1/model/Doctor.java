package com.MichalWojcik.Clinic1.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name, surname,medicalSpecialization;
    private int age;
//    private List<Patient> patients = new ArrayList<>();
//    public Integer getSize(){
//        return getPatients().size();
//    }
//    public List<Patient> getPatients() {
//        return patients;
//    }
//
//    public Doctor(List<Patient> patients) {
//        this.patients = patients;
//    }

    public Doctor() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getMedicalSpecialization() {
        return medicalSpecialization;
    }

    public void setMedicalSpecialization(String medicalSpecialization) {
        this.medicalSpecialization = medicalSpecialization;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: "+getName()+" Surname: "+ getSurname()+ " Age: "+getAge()+" Medical specialization: "+getMedicalSpecialization();
    }
    public String fullName(){
        return getName()+" "+getSurname();
    }
}
