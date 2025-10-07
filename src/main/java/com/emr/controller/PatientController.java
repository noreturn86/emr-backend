package com.emr.controller;

import com.emr.model.Patient;
import com.emr.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;

import com.emr.dto.PatientSummaryDTO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private final PatientRepository patientRepository;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<PatientSummaryDTO> getAllPatients() {
        return patientRepository.findAll().stream()
            .map(p -> new PatientSummaryDTO(
                p.getId(),
                p.getFirstName(),
                p.getLastName(),
                p.getDob().format(formatter),
                p.getHealthCardNumber(),
                p.getSex()
            ))
            .toList();
    }
    
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id)
                .map(patient -> ResponseEntity.ok().body(patient))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable Long id,
            @RequestBody Map<String, String> updates) {

        return patientRepository.findById(id)
                .map(patient -> {
                    if (updates.containsKey("email")) {
                        patient.setEmail(updates.get("email"));
                    }
                    if (updates.containsKey("phoneNumber")) {
                        patient.setPhoneNumber(updates.get("phoneNumber"));
                    }
                    // Add more fields here if needed
                    Patient updated = patientRepository.save(patient);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable Long id) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patientRepository.delete(patient);
                    return ResponseEntity.ok(patient); // return the deleted patient
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
