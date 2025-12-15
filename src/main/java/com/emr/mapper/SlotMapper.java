package com.emr.mapper;

import com.emr.dto.AvailableSlotsDTO;
import com.emr.model.Slot;

public class SlotMapper {

    public static AvailableSlotsDTO toAvailableSlotDTO(Slot slot) {
        return new AvailableSlotsDTO(
                slot.getId(),
                slot.getDatetime(),
                slot.getProvider().getId()
        );
    }
}
