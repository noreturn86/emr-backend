package com.emr.model;

import jakarta.persistence.*;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import com.emr.model.ChronicCondition;
import com.emr.model.ConsultantLetter;
import com.emr.model.Medication;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "patients")
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private LocalDate dob;
    
    @Column(name = "health_card_number", nullable = false, unique = true)
    private String healthCardNumber;
    
    @Column(nullable = false)
    private String sex;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LabResult> labResults;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval= true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ChronicCondition> chronicConditions = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ConsultantLetter> consultantLetters = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Encounter> encounters = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Medication> medications = new ArrayList<>();

    public Patient() {}
    public Patient(String firstName, String lastName, LocalDate dob, String healthCardNumber, String sex, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.healthCardNumber = healthCardNumber;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //getters and setters
    public Long getId() { return id; } 
    public void setId(Long id) { this.id = id; } 
    public String getFirstName() { return firstName; } 
    public void setFirst_name(String firstName) { this.firstName = firstName; } 
    public String getLastName() { return lastName; } 
    public void setLastName(String lastName) { this.lastName = lastName; } 
    public LocalDate getDob() { return dob; } 
    public void setDob(LocalDate dob) { this.dob = dob; } 
    public String getHealthCardNumber() { return healthCardNumber; } 
    public void setHealthCardNumber(String healthCardNumber) { this.healthCardNumber = healthCardNumber; } 
    public String getSex() { return sex; } 
    public void setSex(String sex) { this.sex = sex; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}