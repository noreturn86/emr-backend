package com.emr.repository;

import com.emr.model.Slot;
import com.emr.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

    // Find all slots for a given provider between two datetimes
    List<Slot> findByProviderAndDatetimeBetween(Provider provider, Date start, Date end);
}
