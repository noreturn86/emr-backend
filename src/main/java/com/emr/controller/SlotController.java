package com.emr.controller;

import com.emr.model.Slot;
import com.emr.model.Provider;
import com.emr.repository.SlotRepository;
import com.emr.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Calendar;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private ProviderRepository providerRepository;

    // 1. Get all slots for a provider on a specific date
    @GetMapping("/provider/day")
    public List<Slot> getSlotsForProviderByDate(
        @RequestParam Long providerId,
        @RequestParam Date date
    ) {
    Provider provider = providerRepository.findById(providerId)
            .orElseThrow(() -> new RuntimeException("Provider not found"));

    // Compute start/end of the day
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    Date startOfDay = cal.getTime();

    cal.set(Calendar.HOUR_OF_DAY, 23);
    cal.set(Calendar.MINUTE, 59);
    cal.set(Calendar.SECOND, 59);
    cal.set(Calendar.MILLISECOND, 999);
    Date endOfDay = cal.getTime();

    return slotRepository.findByProviderAndDatetimeBetween(provider, startOfDay, endOfDay);
}


    // 2. Add a new slot for a provider with null patientId
    @PostMapping("/add")
    public Slot addSlot(
        @RequestParam Long providerId,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date datetime
    ) {
        Provider provider = providerRepository.findById(providerId)
            .orElseThrow(() -> new RuntimeException("Provider not found"));

        Slot newSlot = new Slot();
        newSlot.setProvider(provider);
        newSlot.setPatientId(null);
        newSlot.setDatetime(datetime);

        return slotRepository.save(newSlot);
    }
}
