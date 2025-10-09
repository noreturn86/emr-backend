package com.emr.model;

import jakarta.persistence.*;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "prescription_sentences")
public class PrescriptionSentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "script_text", nullable = false)
    public String scriptText;

    //constructors
    public PrescriptionSentence() {}

    //getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getScriptText() { return scriptText; }
    public void setScriptText(String scriptText) { this.scriptText = scriptText; }
}