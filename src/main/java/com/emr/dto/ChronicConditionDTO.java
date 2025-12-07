package com.emr.dto;

public class ChronicConditionDTO {
    private Long id;
    private Long patientId;
    private String conditionName;

    public ChronicConditionDTO() {}

    public ChronicConditionDTO(Long id, Long patientId, String conditionName) {
        this.id = id;
        this.patientId = patientId;
        this.conditionName = conditionName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public String getConditionName() { return conditionName; }
    public void setConditionName(String conditionName) { this.conditionName = conditionName; }
}
