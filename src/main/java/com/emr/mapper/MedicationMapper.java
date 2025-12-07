package com.emr.mapper;

import com.emr.dto.MedicationDTO;
import com.emr.model.Medication;
import com.emr.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class MedicationMapper {

    // Entity → DTO
    public static MedicationDTO toDTO(Medication medication) {
        if (medication == null) return null;

        return new MedicationDTO(
                medication.getId(),
                medication.getPatient() != null ? medication.getPatient().getId() : null,
                medication.getPrescription()
        );
    }

    // DTO → Entity
    public static Medication toEntity(MedicationDTO dto) {
        if (dto == null) return null;

        Medication medication = new Medication();
        medication.setId(dto.getId());
        medication.setPrescription(dto.getPrescription());

        if (dto.getPatientId() != null) {
            Patient p = new Patient();
            p.setId(dto.getPatientId());
            medication.setPatient(p);
        }

        return medication;
    }

    // List<Entity> → List<DTO>
    public static List<MedicationDTO> toDTOList(List<Medication> meds) {
        return meds.stream()
                .map(MedicationMapper::toDTO)  // reference static method via class
                .collect(Collectors.toList());
    }

    // List<DTO> → List<Entity>
    public static List<Medication> toEntityList(List<MedicationDTO> dtos) {
        return dtos.stream()
                .map(MedicationMapper::toEntity)  // reference static method via class
                .collect(Collectors.toList());
    }
}
