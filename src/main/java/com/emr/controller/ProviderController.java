package com.emr.controller;

import com.emr.model.Provider;
import com.emr.repository.ProviderRepository;

import com.emr.security.ProviderDetails;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") //frontend
public class ProviderController {

    private final ProviderRepository providerRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ProviderController(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @GetMapping("/me")
    public Provider getMyInfo(@AuthenticationPrincipal ProviderDetails details) {
        return details.getProvider();
    }

    @PostMapping("/register-provider")
    public ResponseEntity<?> registerProvider(@RequestBody(required = false) Provider provider) {
        if (provider == null) {
            System.out.println("Received null provider: JSON parsing failed or empty body");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Invalid or missing JSON body\"}");
        }

        System.out.println("Received provider: " +
                "firstName=" + provider.getFirstName() +
                ", lastName=" + provider.getLastName() +
                ", email=" + provider.getEmail() +
                ", password=" + (provider.getPassword() != null ? "*****" : null));

        //validate required fields
        if (provider.getFirstName() == null || provider.getLastName() == null ||
            provider.getEmail() == null || provider.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Name, email, and password are required\"}");
        }

        if (providerRepository.findByEmail(provider.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Email already registered\"}");
        }

        provider.setPassword(passwordEncoder.encode(provider.getPassword()));

        providerRepository.save(provider);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("{\"username\": \"" + provider.getEmail() + "\"}");
    }
}
