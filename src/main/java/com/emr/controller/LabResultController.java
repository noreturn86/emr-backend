package com.emr.controller;

import com.emr.model.LabResult;
import com.emr.repository.LabResultRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


@RestController
@RequestMapping("/lab_results")
public class LabResultController {
    @Autowired
    private LabResultRepository labResultRepository;

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<LabResult>> getLabResultsByPatientId(@PathVariable Long patientId) {
        List<LabResult> results = labResultRepository.findByPatientId(patientId);
        if (results.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(results);
        }
    }
}