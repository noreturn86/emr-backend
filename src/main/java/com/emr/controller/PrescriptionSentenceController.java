package com.emr.controller;

import com.emr.model.PrescriptionSentence;
import com.emr.repository.PrescriptionSentenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/prescription_sentences")
public class PrescriptionSentenceController {

    @Autowired
    private PrescriptionSentenceRepository prescriptionSentenceRepository;

    @GetMapping
    public ResponseEntity<List<PrescriptionSentence>> getAllPrescriptionSentences() {
        List<PrescriptionSentence> sentences = prescriptionSentenceRepository.findAll();
        return ResponseEntity.ok(sentences);
    }
}
