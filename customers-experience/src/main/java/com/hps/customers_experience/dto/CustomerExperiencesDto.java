package com.hps.customers_experience.dto;

import lombok.Data;

@Data
public class CustomerExperiencesDto {
    private Long id;
    private Long customerId;
    private String customerName;
    private String needType;
    private String missionType;
    private String touchpointType;
    private String journeyPhase;
    private String placeOfPurchase;
}
