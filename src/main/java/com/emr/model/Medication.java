package com.emr.model;

import jakarta.persistence.*;
import com.emr.model.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonBackReference
    private Patient patient;

    @Column(name = "prescription", nullable = false)
    private String prescription;

    // Constructors
    public Medication() {}

    public Medication(Patient patient, String prescription) {
        this.patient = patient;
        this.prescription = prescription;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public String getPrescription() { return prescription; }
    public void setPrescription(String prescription) { this.prescription = prescription; }
}
