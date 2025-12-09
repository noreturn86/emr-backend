package com.emr.repository;

import com.emr.model.Slot;
import com.emr.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findByProvider(Provider provider);
    List<Slot> findByPatientIdIsNull();
}
