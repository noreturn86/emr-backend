package com.emr.repository;

import com.emr.model.ConsultantLetter;
import com.emr.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConsultantLetterRepository extends JpaRepository<ConsultantLetter, Long> {
    List<ConsultantLetter> findByPatient(Patient patient);
}
