package com.emr.dto;

import java.time.LocalDate;

public class ConsultantLetterDTO {

    private Long id;
    private LocalDate letterDate;
    private String specialistType;
    private String summary;
    private Long patientId;

    public ConsultantLetterDTO() {}

    public ConsultantLetterDTO(
            Long id,
            LocalDate letterDate,
            String specialistType,
            String summary,
            Long patientId
    ) {
        this.id = id;
        this.letterDate = letterDate;
        this.specialistType = specialistType;
        this.summary = summary;
        this.patientId = patientId;
    }


    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getLetterDate() { return letterDate; }
    public void setLetterDate(LocalDate letterDate) { this.letterDate = letterDate; }

    public String getSpecialistType() { return specialistType; }
    public void setSpecialistType(String specialistType) { this.specialistType = specialistType; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
}
