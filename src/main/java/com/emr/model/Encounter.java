package com.emr.model;

import jakarta.persistence.*;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "encounters")
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "provider_id", nullable = false)
    private int providerId;

    @Column(name = "encounter_date", nullable = false)
    private LocalDate encounterDate;

    private String summary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonBackReference
    private Patient patient;

    //constructors
    public Encounter() {}

    //getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getProviderId() { return providerId; }
    public void setProviderId(int providerId) { this.providerId = providerId; }
    public LocalDate getEncounterDate() { return encounterDate; }
    public void setEncounterDate(LocalDate encounterDate) { this.encounterDate = encounterDate; }
    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
}