package com.emr.mapper;

import com.emr.model.*;
import com.emr.dto.*;
import com.emr.mapper.*;

import com.emr.dto.PatientDTO;
import com.emr.dto.PatientFullDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {

    // --- BASIC (PatientDTO) ---
    public static PatientDTO toDTO(Patient p) {
        if (p == null) return null;

        return new PatientDTO(
                p.getId(),
                p.getFirstName(),
                p.getLastName(),
                p.getDob(),
                p.getHealthCardNumber(),
                p.getSexAtBirth(),
                p.getPhonePrimary(),
                p.getEmail()
        );
    }

    // --- FULL (PatientFullDTO) ---
    public static PatientFullDTO toFullDTO(Patient p) {
    if (p == null) return null;

    // Explicitly define lists to help compiler
    List<ChronicConditionDTO> chronicConditionDTOs = p.getChronicConditions().stream()
            .map((ChronicCondition cc) -> ChronicConditionMapper.toDTO(cc))
            .collect(Collectors.toList());

    List<ConsultantLetterDTO> consultantLetterDTOs = p.getConsultantLetters().stream()
            .map((ConsultantLetter cl) -> ConsultantLetterMapper.toDTO(cl))
            .collect(Collectors.toList());

    List<EncounterDTO> encounterDTOs = p.getEncounters().stream()
            .map((Encounter e) -> EncounterMapper.toDTO(e))
            .collect(Collectors.toList());

    List<MedicationDTO> medicationDTOs = p.getMedications().stream()
            .map((Medication m) -> MedicationMapper.toDTO(m))
            .collect(Collectors.toList());

    List<ImagingReportDTO> imagingReportDTOs = p.getImagingReports().stream()
            .map((ImagingReport ir) -> ImagingReportMapper.toDTO(ir))
            .collect(Collectors.toList());

    List<LabResultDTO> labResultDTOs = p.getLabResults().stream()
            .map((LabResult lr) -> LabResultMapper.toDTO(lr))
            .collect(Collectors.toList());

    List<ExamDataDTO> examDataDTOs = p.getExamData().stream()
            .map((ExamData ed) -> ExamDataMapper.toDTO(ed))
            .collect(Collectors.toList());

    return new PatientFullDTO(
            p.getId(),
            p.getFirstName(),
            p.getLastName(),
            p.getDob(),
            p.getHealthCardNumber(),
            p.getSexAtBirth(),
            p.getPhonePrimary(),
            p.getEmail(),
            chronicConditionDTOs,
            consultantLetterDTOs,
            encounterDTOs,
            medicationDTOs,
            imagingReportDTOs,
            labResultDTOs,
            examDataDTOs
    );
}


}
