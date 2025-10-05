package com.emr.repository;

import com.emr.model.ChronicCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChronicConditionRepository extends JpaRepository<ChronicCondition, Long> {
    List<ChronicCondition> findByPatient_Id(Long patientId);
}

