package com.emr.controller;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.emr.model.ImagingReport;
import com.emr.repository.ImagingReportRepository;
import com.emr.model.Patient;
import com.emr.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


@RestController
@RequestMapping("/imaging_reports")
public class ImagingReportController {
    @Autowired
    private ImagingReportRepository imagingReportRepository;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ImagingReport> getReportById(@PathVariable Long id) {
        return imagingReportRepository.findById(id)
                .map(report -> ResponseEntity.ok().body(report))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patient/{patientId}")
    public List<ImagingReport> getReportsByPatient(@PathVariable Long patientId) {
        Patient patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return imagingReportRepository.findByPatient(patient);
    }
}