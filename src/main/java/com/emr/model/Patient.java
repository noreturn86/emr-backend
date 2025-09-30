package com.emr.model;

import jakarta.persistence.*;

import java.lang.annotation.Inherited;
import java.util.List;
import java.time.LocalDate;


@Entity
@Table(name = "patients")
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private LocalDate dob;
    private String health_card_number;
    private String sex;

    public Patient() {}
    public Patient(String first_name, String last_name, LocalDate dob, String health_card_number, String sex) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.health_card_number = health_card_number;
        this.sex = sex;
    }

    //getters and setters
    public Long getId() { return id; } 
    public void setId(Long id) { this.id = id; } 
    public String getFirst_name() { return first_name; } 
    public void setFirst_name(String first_name) { this.first_name = first_name; } 
    public String getLast_name() { return last_name; } 
    public void setLast_name(String last_name) { this.last_name = last_name; } 
    public LocalDate getDob() { return dob; } 
    public void setDob(LocalDate dob) { this.dob = dob; } 
    public String getHealth_card_number() { return health_card_number; } 
    public void setHealth_card_number(String health_card_number) { this.health_card_number = health_card_number; } 
    public String getSex() { return sex; } public void setSex(String sex) { this.sex = sex; }
}