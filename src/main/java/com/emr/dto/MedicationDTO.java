package com.emr.dto;

public class MedicationDTO {
    private Long id;
    private Long patientId;
    private String prescription;

    public MedicationDTO() {}

    public MedicationDTO(Long id, Long patientId, String prescription) {
        this.id = id;
        this.patientId = patientId;
        this.prescription = prescription;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public String getPrescription() { return prescription; }
    public void setPrescription(String prescription) { this.prescription = prescription; }
}
