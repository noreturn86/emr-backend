package com.emr.dto;

public record PatientSummaryDTO(
        Long id,
        String firstName,
        String lastName,
        String dob,
        String healthCardNumber,
        String sex
) {}
