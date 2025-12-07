package com.emr.dto;

import java.time.LocalDate;

public class ExamDataDTO {
    private Long id;
    private Long patientId;
    private LocalDate date;
    private String dataType;
    private String value;
    private String units;

    public ExamDataDTO() {}

    public ExamDataDTO(Long id, Long patientId, LocalDate date, String dataType, String value, String units) {
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.dataType = dataType;
        this.value = value;
        this.units = units;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDataType() { return dataType; }
    public void setDataType(String dataType) { this.dataType = dataType; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public String getUnits() { return units; }
    public void setUnits(String units) { this.units = units; }
}
