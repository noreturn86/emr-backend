package com.emr.dto;

import java.time.LocalDate;
import java.util.List;

// Import DTOs instead of entities
import com.emr.dto.ChronicConditionDTO;
import com.emr.dto.ConsultantLetterDTO;
import com.emr.dto.EncounterDTO;
import com.emr.dto.MedicationDTO;
import com.emr.dto.ImagingReportDTO;
import com.emr.dto.LabResultDTO;
import com.emr.dto.ExamDataDTO;

public class PatientFullDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String healthCardNumber;
    private String sex;
    private String phoneNumber;
    private String email;

    private List<ChronicConditionDTO> chronicConditions;
    private List<ConsultantLetterDTO> consultantLetters;
    private List<EncounterDTO> encounters;
    private List<MedicationDTO> medications;
    private List<ImagingReportDTO> imagingReports;
    private List<LabResultDTO> labResults;
    private List<ExamDataDTO> examData;

    public PatientFullDTO() {}

    public PatientFullDTO(
            Long id,
            String firstName,
            String lastName,
            LocalDate dob,
            String healthCardNumber,
            String sex,
            String phoneNumber,
            String email,
            List<ChronicConditionDTO> chronicConditions,
            List<ConsultantLetterDTO> consultantLetters,
            List<EncounterDTO> encounters,
            List<MedicationDTO> medications,
            List<ImagingReportDTO> imagingReports,
            List<LabResultDTO> labResults,
            List<ExamDataDTO> examData
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.healthCardNumber = healthCardNumber;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.chronicConditions = chronicConditions;
        this.consultantLetters = consultantLetters;
        this.encounters = encounters;
        this.medications = medications;
        this.imagingReports = imagingReports;
        this.labResults = labResults;
        this.examData = examData;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getHealthCardNumber() { return healthCardNumber; }
    public void setHealthCardNumber(String healthCardNumber) { this.healthCardNumber = healthCardNumber; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<ChronicConditionDTO> getChronicConditions() { return chronicConditions; }
    public void setChronicConditions(List<ChronicConditionDTO> chronicConditions) { this.chronicConditions = chronicConditions; }

    public List<ConsultantLetterDTO> getConsultantLetters() { return consultantLetters; }
    public void setConsultantLetters(List<ConsultantLetterDTO> consultantLetters) { this.consultantLetters = consultantLetters; }

    public List<EncounterDTO> getEncounters() { return encounters; }
    public void setEncounters(List<EncounterDTO> encounters) { this.encounters = encounters; }

    public List<MedicationDTO> getMedications() { return medications; }
    public void setMedications(List<MedicationDTO> medications) { this.medications = medications; }

    public List<ImagingReportDTO> getImagingReports() { return imagingReports; }
    public void setImagingReports(List<ImagingReportDTO> imagingReports) { this.imagingReports = imagingReports; }

    public List<LabResultDTO> getLabResults() { return labResults; }
    public void setLabResults(List<LabResultDTO> labResults) { this.labResults = labResults; }

    public List<ExamDataDTO> getExamData() { return examData; }
    public void setExamData(List<ExamDataDTO> examData) { this.examData = examData; }
}
