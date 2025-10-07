package com.emr.controller;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.emr.model.ConsultantLetter;
import com.emr.repository.ConsultantLetterRepository;
import com.emr.model.Patient;
import com.emr.repository.PatientRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


@RestController
@RequestMapping("/consultant_letters")
public class ConsultantLetterController {
    @Autowired
    private ConsultantLetterRepository consultantLetterRepository;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ConsultantLetter> getLetterById(@PathVariable Long id) {
        return consultantLetterRepository.findById(id)
                .map(letter -> ResponseEntity.ok().body(letter))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patient/{patientId}")
    public List<ConsultantLetter> getLettersByPatient(@PathVariable Long patientId) {
        Patient patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return consultantLetterRepository.findByPatient(patient);
    }
}