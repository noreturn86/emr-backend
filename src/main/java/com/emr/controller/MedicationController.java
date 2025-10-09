package com.emr.controller;

import com.emr.model.Medication;
import com.emr.repository.MedicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    @Autowired
    private MedicationRepository medicationRepository;

    //get all medications
    @GetMapping
    public ResponseEntity<List<Medication>> getAllMedications() {
        return ResponseEntity.ok(medicationRepository.findAll());
    }

    //get medications by patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Medication>> getMedicationsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(medicationRepository.findByPatientId(patientId));
    }

    //add a new medication
    @PostMapping
    public ResponseEntity<Medication> addMedication(@RequestBody Medication medication) {
        Medication savedMed = medicationRepository.save(medication);
        return ResponseEntity.ok(savedMed);
    }

    //delete a medication
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long id) {
        if (!medicationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        medicationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
