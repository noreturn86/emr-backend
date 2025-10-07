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

    private String summary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonBackReference
    private Patient patient;


    //constructors
    public ConsultantLetter() {}
}