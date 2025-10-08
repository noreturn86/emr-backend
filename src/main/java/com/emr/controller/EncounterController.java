package com.emr.controller;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
import com.emr.model.Patient;
import com.emr.model.Encounter;
import com.emr.repository.PatientRepository;
import com.emr.repository.EncounterRepository;


@RestController
@RequestMapping("/encounters")
public class EncounterController {
    @Autowired
    private EncounterRepository encounterRepository;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Encounter> getEncounterById(@PathVariable Long id) {
        return encounterRepository.findById(id)
                .map(encounter -> ResponseEntity.ok().body(encounter))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patient/{patientId}")
    public List<Encounter> getEncountersByPatient(@PathVariable Long patientId) {
        Patient patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return encounterRepository.findByPatient(patient);
    }
}