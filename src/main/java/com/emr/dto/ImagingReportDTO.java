package com.emr.dto;

import java.time.LocalDate;

public class ImagingReportDTO {
    private Long id;
    private Long patientId;
    private LocalDate date;
    private String testType;
    private String resultSummary;

    public ImagingReportDTO() {}

    public ImagingReportDTO(Long id, Long patientId, LocalDate date, String testType, String resultSummary) {
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.testType = testType;
        this.resultSummary = resultSummary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getTestType() { return testType; }
    public void setTestType(String testType) { this.testType = testType; }

    public String getResultSummary() { return resultSummary; }
    public void setResultSummary(String resultSummary) { this.resultSummary = resultSummary; }
}
