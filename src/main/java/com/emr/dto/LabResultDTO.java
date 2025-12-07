package com.emr.dto;

import java.time.LocalDate;

public class LabResultDTO {
    private Long id;
    private Long patientId;
    private LocalDate testDate;
    private String testType;
    private String resultValue;
    private String units;

    public LabResultDTO() {}

    public LabResultDTO(Long id, Long patientId, LocalDate testDate, String testType, String resultValue, String units) {
        this.id = id;
        this.patientId = patientId;
        this.testDate = testDate;
        this.testType = testType;
        this.resultValue = resultValue;
        this.units = units;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public LocalDate getTestDate() { return testDate; }
    public void setTestDate(LocalDate testDate) { this.testDate = testDate; }

    public String getTestType() { return testType; }
    public void setTestType(String testType) { this.testType = testType; }

    public String getResultValue() { return resultValue; }
    public void setResultValue(String resultValue) { this.resultValue = resultValue; }

    public String getUnits() { return units; }
    public void setUnits(String units) { this.units = units; }
}
