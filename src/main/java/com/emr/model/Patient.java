package com.emr.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private LocalDate dob;

    @Column(name = "health_card_number", unique = true)
    private String healthCardNumber;

    @Column(name = "sex")
    private String sexAtBirth;

    @Column(name = "phone_number")
    private String phonePrimary;

    @Column(nullable = false)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String gender;

    @Column(name = "phone_secondary")
    private String phoneSecondary;

    @Column(name = "street_address")
    private String streetAddress;

    private String city;

    private String province;

    @Column(name = "postal_code")
    private String postalCode;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ChronicCondition> chronicConditions = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ConsultantLetter> consultantLetters = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Encounter> encounters = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Medication> medications = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ImagingReport> imagingReports = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<LabResult> labResults = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ExamData> examData = new ArrayList<>();

    public Patient() {}

    public Patient(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

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
    public String getSexAtBirth() { return sexAtBirth; } 
    public void setSexAtBirth(String sexAtBirth) { this.sexAtBirth = sexAtBirth; }
    public String getPhonePrimary() { return phonePrimary; } 
    public void setPhonePrimary(String phonePrimary) { this.phonePrimary = phonePrimary; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getGender() { return gender; } public void setGender(String gender) { this.gender = gender; }
    public String getPhoneSecondary() { return phoneSecondary; } 
    public void setPhoneSecondary(String phoneSecondary) { this.phoneSecondary = phoneSecondary; }
    public String getStreetAddress() { return streetAddress; } 
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public String getCity() { return city; } 
    public void setCity(String city) { this.city = city; }
    public String getProvince() { return province; } 
    public void setProvince(String province) { this.province = province; }
    public String getPostalCode() { return postalCode; } 
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public List<ChronicCondition> getChronicConditions() { return chronicConditions; }
    public void setChronicConditions(List<ChronicCondition> chronicConditions) { this.chronicConditions = chronicConditions; }
    public List<ConsultantLetter> getConsultantLetters() { return consultantLetters; }
    public void setConsultantLetters(List<ConsultantLetter> consultantLetters) { this.consultantLetters = consultantLetters; }
    public List<Encounter> getEncounters() { return encounters; }
    public void setEncounters(List<Encounter> encounters) { this.encounters = encounters; }
    public List<Medication> getMedications() { return medications; }
    public void setMedications(List<Medication> medications) { this.medications = medications; }
    public List<ImagingReport> getImagingReports() { return imagingReports; }
    public void setImagingReports(List<ImagingReport> imagingReports) { this.imagingReports = imagingReports; }
    public List<LabResult> getLabResults() { return labResults; }
    public void setLabResults(List<LabResult> labResults) { this.labResults = labResults; }
    public List<ExamData> getExamData() { return examData; }
    public void setExamData(List<ExamData> examData) { this.examData = examData; }
}
