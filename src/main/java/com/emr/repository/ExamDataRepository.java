package com.emr.repository;

import com.emr.model.ExamData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExamDataRepository extends JpaRepository<ExamData, Long> {
    List<ExamData> findByPatientId(Long patientId);
}
