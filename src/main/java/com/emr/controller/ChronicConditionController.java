package com.emr.controller;

import com.emr.model.ChronicCondition;
import com.emr.repository.ChronicConditionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/chronic_conditions")
public class ChronicConditionController {
    @Autowired
    private ChronicConditionRepository chronicConditionRepository;

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ChronicCondition>> getChronicConditionsByPatientId(@PathVariable Long patientId) {
        List<ChronicCondition> conditions = chronicConditionRepository.findByPatient_Id(patientId);
        if (conditions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(conditions);
        }
    }
}
