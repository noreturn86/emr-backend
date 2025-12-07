package com.emr.mapper;

import com.emr.dto.EncounterDTO;
import com.emr.model.Encounter;

public class EncounterMapper {

    public static EncounterDTO toDTO(Encounter encounter) {
        if (encounter == null) return null;

        return new EncounterDTO(
                encounter.getId(),
                encounter.getProviderId(),
                encounter.getEncounterDate(),
                encounter.getSummary(),
                encounter.getPatient() != null ? encounter.getPatient().getId() : null
        );
    }

    public static Encounter toEntity(EncounterDTO dto) {
        if (dto == null) return null;

        Encounter encounter = new Encounter();
        encounter.setId(dto.getId());
        encounter.setProviderId(dto.getProviderId());
        encounter.setEncounterDate(dto.getEncounterDate());
        encounter.setSummary(dto.getSummary());
        // Patient assignment handled in service layer

        return encounter;
    }
}
