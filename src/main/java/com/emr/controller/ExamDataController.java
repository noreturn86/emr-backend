package com.emr.controller;

import com.emr.model.ExamData;
import com.emr.repository.ExamDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


@RestController
@RequestMapping("/exam_data")
public class ExamDataController {
    @Autowired
    private ExamDataRepository examDataRepository;

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ExamData>> getExamDataByPatientId(@PathVariable Long patientId) {
        List<ExamData> data = examDataRepository.findByPatientId(patientId);
        if (data.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(data);
        }
    }
}