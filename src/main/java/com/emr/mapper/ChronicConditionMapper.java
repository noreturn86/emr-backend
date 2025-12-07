package com.emr.mapper;

import com.emr.model.ChronicCondition;
import com.emr.dto.ChronicConditionDTO;

public class ChronicConditionMapper {

    public static ChronicConditionDTO toDTO(ChronicCondition cc) {
        if (cc == null) return null;

        return new ChronicConditionDTO(
                cc.getId(),
                cc.getPatientId(),      // safe helper you already built
                cc.getConditionName()
        );
    }

    public static ChronicCondition toEntity(ChronicConditionDTO dto) {
        if (dto == null) return null;

        ChronicCondition cc = new ChronicCondition();
        cc.setId(dto.getId());
        cc.setConditionName(dto.getConditionName());

        // Do NOT set patient entity here — handled in PatientService
        return cc;
    }
}
