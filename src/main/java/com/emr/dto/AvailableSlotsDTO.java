package com.emr.dto;

import java.util.Date;

public record AvailableSlotsDTO(
        Long slotId,
        Date datetime,
        Long providerId
) {}
