package com.emr.controller;

import com.emr.model.Patient;
import com.emr.repository.PatientRepository;

import com.emr.dto.PatientAccountUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;

import com.emr.dto.PatientSummaryDTO;
import com.emr.dto.PatientFullDTO;
import java.time.format.DateTimeFormatter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.http.HttpStatus;

import com.emr.mapper.PatientMapper;


@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private final PatientRepository patientRepository;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final BCryptPasswordEncoder passwordEncoder;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/register-patient")
    public ResponseEntity<?> registerPatient(@RequestBody(required = false) Patient patient) {
        if (patient == null) {
            System.out.println("Received null provider: JSON parsing failed or empty body");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Invalid or missing JSON body\"}");
        }

        System.out.println("Received provider: " +
                "firstName=" + patient.getFirstName() +
                ", lastName=" + patient.getLastName() +
                ", email=" + patient.getEmail() +
                ", password=" + (patient.getPassword() != null ? "*****" : null));

        //validate required fields
        if (patient.getFirstName() == null || patient.getLastName() == null ||
            patient.getEmail() == null || patient.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Name, email, and password are required\"}");
        }

        //check if patient is already registered
        if (patientRepository.findByEmail(patient.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Email already registered\"}");
        }

        patient.setPassword(passwordEncoder.encode(patient.getPassword()));

        patientRepository.save(patient);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("{\"username\": \"" + patient.getEmail() + "\"}");
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
                p.getSexAtBirth()
            ))
            .toList();
    }
    
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @PutMapping("/{id}/account")
    public ResponseEntity<?> updatePatientAccount(
            @PathVariable Long id,
            @RequestBody PatientAccountUpdateDTO dto
    ) {
        Patient patient = patientRepository.findById(id).orElse(null);

        if (patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"Patient not found\"}");
        }

        // --- Update all allowed fields from the DTO ---
        patient.setDob(dto.getDob());
        patient.setHealthCardNumber(dto.getHealthCardNumber());
        patient.setSexAtBirth(dto.getSexAtBirth());
        patient.setGender(dto.getGender());
        patient.setPhonePrimary(dto.getPhonePrimary());
        patient.setPhoneSecondary(dto.getPhoneSecondary());
        patient.setStreetAddress(dto.getStreetAddress());
        patient.setCity(dto.getCity());
        patient.setProvince(dto.getProvince());
        patient.setPostalCode(dto.getPostalCode());

        patientRepository.save(patient);

        return ResponseEntity.ok().build();
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
                        patient.setPhonePrimary(updates.get("phoneNumber"));
                    }
                    Patient updated = patientRepository.save(patient);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/full/{id}")
    public ResponseEntity<PatientFullDTO> getPatientFull(@PathVariable Long id) {
        return patientRepository.findById(id)
                .map(patient -> {
                    //mapper converts Patient -> PatientFullDTO
                    PatientFullDTO dto = PatientMapper.toFullDTO(patient);
                    return ResponseEntity.ok(dto);
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
