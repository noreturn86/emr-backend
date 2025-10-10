package com.emr.repository;

import com.emr.model.ImagingReport;
import com.emr.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImagingReportRepository extends JpaRepository<ImagingReport, Long> {
    List<ImagingReport> findByPatient(Patient patient);
}
