package com.emr.controller;

import com.emr.model.Provider;
import com.emr.model.Patient;
import com.emr.repository.ProviderRepository;
import com.emr.repository.PatientRepository;
import com.emr.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    private final ProviderRepository providerRepository;
    private final PatientRepository patientRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/login-provider")
    public LoginResponse loginProvider(@RequestBody LoginRequest req) {

        Provider provider = providerRepository.findByEmail(req.email())
                .orElseThrow(() -> new RuntimeException("Invalid email/password"));

        if (!encoder.matches(req.password(), provider.getPassword())) {
            throw new RuntimeException("Invalid email/password");
        }

        String token = jwtService.generateToken(provider.getEmail(), "PROVIDER");
        return new LoginResponse(token, provider);
    }

    @PostMapping("/login-patient")
    public PatientLoginResponse loginPatient(@RequestBody LoginRequest req) {

        Patient patient = patientRepository.findByEmail(req.email())
                .orElseThrow(() -> new RuntimeException("Invalid email/password"));

        if (!encoder.matches(req.password(), patient.getPassword())) {
            throw new RuntimeException("Invalid email/password");
        }

        String token = jwtService.generateToken(patient.getEmail(), "PATIENT");
        return new PatientLoginResponse(token, patient);
    }
}

record LoginRequest(String email, String password) {}

record LoginResponse(String token, Provider provider) {}

record PatientLoginResponse(String token, Patient patient) {}
