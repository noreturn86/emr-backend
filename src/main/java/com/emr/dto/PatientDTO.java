package com.emr.dto;

import java.time.LocalDate;

public class PatientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String healthCardNumber;
    private String sex;
    private String phoneNumber;
    private String email;

    public PatientDTO() {}

    public PatientDTO(
            Long id,
            String firstName,
            String lastName,
            LocalDate dob,
            String healthCardNumber,
            String sex,
            String phoneNumber,
            String email
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.healthCardNumber = healthCardNumber;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
}
