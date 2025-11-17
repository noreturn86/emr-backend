package com.emr.controller;

import com.emr.model.Provider;
import com.emr.repository.ProviderRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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


    @PostMapping("/login-provider")
    public ResponseEntity<?> loginProvider(@RequestBody Map<String, String> loginData) {
        try {
            String email = loginData.get("email");
            String password = loginData.get("password");

            if (email == null || password == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("message", "Email and password are required"));
            }

            Optional<Provider> optionalProvider = providerRepository.findByEmail(email);

            if (optionalProvider.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("message", "Invalid email or password"));
            }

            Provider provider = optionalProvider.get();

            if (!passwordEncoder.matches(password, provider.getPassword())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("message", "Invalid email or password"));
            }

            Map<String, String> response = new HashMap<>();
            response.put("username", provider.getEmail());
            response.put("role", "provider");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Internal server error"));
        }
    }
}
