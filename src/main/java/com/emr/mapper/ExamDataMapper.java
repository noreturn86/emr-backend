package com.emr.mapper;

import com.emr.dto.ExamDataDTO;
import com.emr.model.ExamData;
import com.emr.model.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class ExamDataMapper {

    public static ExamDataDTO toDTO(ExamData examData) {
        if (examData == null) return null;

        return new ExamDataDTO(
                examData.getId(),
                examData.getPatient() != null ? examData.getPatient().getId() : null,
                examData.getDate(),
                examData.getDataType(),
                examData.getValue(),
                examData.getUnits()
        );
    }

    public static ExamData toEntity(ExamDataDTO dto) {
        if (dto == null) return null;

        ExamData examData = new ExamData();
        examData.setId(dto.getId());
        examData.setDate(dto.getDate());
        examData.setDataType(dto.getDataType());
        examData.setValue(dto.getValue());
        examData.setUnits(dto.getUnits());

        if (dto.getPatientId() != null) {
            Patient p = new Patient();
            p.setId(dto.getPatientId());
            examData.setPatient(p);
        }

        return examData;
    }

    public static List<ExamDataDTO> toDTOList(List<ExamData> examDataList) {
        return examDataList.stream().map(ExamDataMapper::toDTO).collect(Collectors.toList());
    }

    public static List<ExamData> toEntityList(List<ExamDataDTO> dtoList) {
        return dtoList.stream().map(ExamDataMapper::toEntity).collect(Collectors.toList());
    }
}
