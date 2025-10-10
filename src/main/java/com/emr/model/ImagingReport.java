package com.emr.model;

import jakarta.persistence.*;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "imaging_reports")
public class ImagingReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonBackReference
    private Patient patient;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "test_type", nullable = false)
    private String testType;

    @Column(name = "result_summary")
    private String resultSummary;


    //constructors
    public ImagingReport() {}

    //getters and setters
    public Long getId() { return id; }  
    public void setId(Long id) { this.id = id; }  
    public Patient getPatient() { return patient; }  
    public void setPatient(Patient patient) { this.patient = patient; }  
    public LocalDate getDate() { return date; }  
    public void setDate(LocalDate date) { this.date = date; }  
    public String getTestType() { return testType; }  
    public void setTestType(String testType) { this.testType = testType; }  
    public String getResultSummary() { return resultSummary; }  
    public void setResultSummary(String resultSummary) { this.resultSummary = resultSummary; } 
}