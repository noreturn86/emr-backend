package com.emr.mapper;

import com.emr.dto.ConsultantLetterDTO;
import com.emr.model.ConsultantLetter;

public class ConsultantLetterMapper {

    public static ConsultantLetterDTO toDTO(ConsultantLetter letter) {
        if (letter == null) return null;

        return new ConsultantLetterDTO(
                letter.getId(),
                letter.getLetterDate(),
                letter.getSpecialistType(),
                letter.getSummary(),
                letter.getPatient() != null ? letter.getPatient().getId() : null
        );
    }

    public static ConsultantLetter toEntity(ConsultantLetterDTO dto) {
        if (dto == null) return null;

        ConsultantLetter letter = new ConsultantLetter();
        letter.setId(dto.getId());
        letter.setLetterDate(dto.getLetterDate());
        letter.setSpecialistType(dto.getSpecialistType());
        letter.setSummary(dto.getSummary());

        // Patient assignment handled in the service layer — not here
        return letter;
    }
}
