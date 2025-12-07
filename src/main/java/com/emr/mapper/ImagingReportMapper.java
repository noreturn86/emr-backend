package com.emr.mapper;

import com.emr.dto.ImagingReportDTO;
import com.emr.model.ImagingReport;
import com.emr.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class ImagingReportMapper {

    // Entity → DTO
    public static ImagingReportDTO toDTO(ImagingReport report) {
        if (report == null) return null;

        return new ImagingReportDTO(
                report.getId(),
                report.getPatient() != null ? report.getPatient().getId() : null,
                report.getDate(),
                report.getTestType(),
                report.getResultSummary()
        );
    }

    // DTO → Entity
    public static ImagingReport toEntity(ImagingReportDTO dto) {
        if (dto == null) return null;

        ImagingReport report = new ImagingReport();
        report.setId(dto.getId());
        report.setDate(dto.getDate());
        report.setTestType(dto.getTestType());
        report.setResultSummary(dto.getResultSummary());

        if (dto.getPatientId() != null) {
            Patient p = new Patient();
            p.setId(dto.getPatientId());
            report.setPatient(p);
        }

        return report;
    }

    // List<Entity> → List<DTO>
    public static List<ImagingReportDTO> toDTOList(List<ImagingReport> reports) {
        return reports.stream()
                    .map(ImagingReportMapper::toDTO) // ClassName::staticMethod
                    .collect(Collectors.toList());
    }

    // List<DTO> → List<Entity>
    public static List<ImagingReport> toEntityList(List<ImagingReportDTO> dtos) {
        return dtos.stream()
                .map(ImagingReportMapper::toEntity) // ClassName::staticMethod
                .collect(Collectors.toList());
    }

}
