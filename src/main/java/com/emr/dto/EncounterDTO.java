package com.emr.dto;

import java.time.LocalDate;

public class EncounterDTO {

    private Long id;
    private int providerId;
    private LocalDate encounterDate;
    private String summary;
    private Long patientId;

    public EncounterDTO() {}

    public EncounterDTO(
            Long id,
            int providerId,
            LocalDate encounterDate,
            String summary,
            Long patientId
    ) {
        this.id = id;
        this.providerId = providerId;
        this.encounterDate = encounterDate;
        this.summary = summary;
        this.patientId = patientId;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getProviderId() { return providerId; }
    public void setProviderId(int providerId) { this.providerId = providerId; }

    public LocalDate getEncounterDate() { return encounterDate; }
    public void setEncounterDate(LocalDate encounterDate) { this.encounterDate = encounterDate; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
}
