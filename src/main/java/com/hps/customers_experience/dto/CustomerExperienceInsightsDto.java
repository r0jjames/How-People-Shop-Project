package com.hps.customers_experience.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        name = "Customer Experience Insights",
        description = "Schema to hold customers insights information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerExperienceInsightsDto {

    private Long customerExperienceId;
    private String title;
    private String description;

}

