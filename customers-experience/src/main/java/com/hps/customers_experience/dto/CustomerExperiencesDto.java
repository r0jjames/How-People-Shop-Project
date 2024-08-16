package com.hps.customers_experience.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(
        name = "Customer Experience",
        description = "Schema to hold customers analytics information"
)
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
