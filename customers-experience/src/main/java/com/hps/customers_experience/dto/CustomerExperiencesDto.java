package com.hps.customers_experience.dto;

import lombok.Data;

@Data
public class CustomerExperiencesDto {
    private String id;
    private String customerId;
    private String customerName;
    private String needType;
    private String missionType;
    private String touchpointType;
    private String journeyPhase;
    private String placeOfPurchase;
}
