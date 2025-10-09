package com.emr.repository;

import com.emr.model.PrescriptionSentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionSentenceRepository extends JpaRepository<PrescriptionSentence, Long> {
}