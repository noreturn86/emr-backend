package com.emr.dto;

import java.time.LocalDate;

public class PatientAccountUpdateDTO {

    private LocalDate dob;
    private String healthCardNumber;
    private String sexAtBirth;
    private String gender;

    private String phonePrimary;
    private String phoneSecondary;

    private String streetAddress;
    private String city;
    private String province;
    private String postalCode;

    // getters and setters
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getHealthCardNumber() { return healthCardNumber; }
    public void setHealthCardNumber(String healthCardNumber) {
        this.healthCardNumber = healthCardNumber;
    }

    public String getSexAtBirth() { return sexAtBirth; }
    public void setSexAtBirth(String sexAtBirth) {
        this.sexAtBirth = sexAtBirth;
    }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhonePrimary() { return phonePrimary; }
    public void setPhonePrimary(String phonePrimary) {
        this.phonePrimary = phonePrimary;
    }

    public String getPhoneSecondary() { return phoneSecondary; }
    public void setPhoneSecondary(String phoneSecondary) {
        this.phoneSecondary = phoneSecondary;
    }

    public String getStreetAddress() { return streetAddress; }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
