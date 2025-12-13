package com.emr.model;

import jakarta.persistence.*;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "consultant_letters")
public class ConsultantLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "letter_date", nullable = false)
    private LocalDate letterDate;

    @Column(name = "specialist_type", nullable = false)
    private String specialistType;

    @Column(length = 1000)
    private String summary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonBackReference
    private Patient patient;


    //constructors
    public ConsultantLetter() {}

    //getters and setters
    public Long getId() { return id; }
    public LocalDate getLetterDate() { return letterDate; }
    public String getSpecialistType() { return specialistType; }
    public String getSummary() { return summary; }
    public Patient getPatient() { return patient; }

    public void setId(Long id) { this.id = id; }
    public void setLetterDate(LocalDate letterDate) { this.letterDate = letterDate; }
    public void setSpecialistType(String specialistType) { this.specialistType = specialistType; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setPatient(Patient patient) { this.patient = patient; }
}