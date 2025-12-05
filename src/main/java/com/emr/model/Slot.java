package com.emr.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "slots")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "datetime")
    private Date datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    @JsonBackReference
    private Provider provider;

    //constructors
    public Slot() {}

    public Slot(Long id, Provider provider, Long patientId, Date datetime) {
        this.id = id;
        this.provider = provider;
        this.patientId = patientId;
        this.datetime = datetime;
    }

    //getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Provider getProvider() { return provider; }
    public void setProvider(Provider provider) { this.provider = provider; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public Date getDatetime() { return datetime; }
    public void setDatetime(Date datetime) { this.datetime = datetime; }
}
