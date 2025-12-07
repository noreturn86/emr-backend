package com.emr.mapper;

import com.emr.dto.LabResultDTO;
import com.emr.model.LabResult;
import com.emr.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class LabResultMapper {

    // Entity → DTO
    public static LabResultDTO toDTO(LabResult labResult) {
        if (labResult == null) return null;

        return new LabResultDTO(
                labResult.getId(),
                labResult.getPatient() != null ? labResult.getPatient().getId() : null,
                labResult.getTestDate(),
                labResult.getTestType(),
                labResult.getResultValue(),
                labResult.getUnits()
        );
    }

    // DTO → Entity
    public static LabResult toEntity(LabResultDTO dto) {
        if (dto == null) return null;

        LabResult labResult = new LabResult();
        labResult.setId(dto.getId());
        labResult.setTestDate(dto.getTestDate());
        labResult.setTestType(dto.getTestType());
        labResult.setResultValue(dto.getResultValue());
        labResult.setUnits(dto.getUnits());

        if (dto.getPatientId() != null) {
            Patient p = new Patient();
            p.setId(dto.getPatientId());
            labResult.setPatient(p);
        }

        return labResult;
    }

    // List<Entity> → List<DTO>
    public static List<LabResultDTO> toDTOList(List<LabResult> labResults) {
        return labResults.stream()
                        .map(LabResultMapper::toDTO)  // reference static method via class
                        .collect(Collectors.toList());
    }

    // List<DTO> → List<Entity>
    public static List<LabResult> toEntityList(List<LabResultDTO> dtos) {
        return dtos.stream()
                .map(LabResultMapper::toEntity)  // reference static method via class
                .collect(Collectors.toList());
    }
}
