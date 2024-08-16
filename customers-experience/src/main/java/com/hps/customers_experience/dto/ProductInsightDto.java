package com.hps.customers_experience.dto;

import com.hps.customers_experience.entity.ProductClusters;
import com.hps.customers_experience.entity.Triggers;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        name = "Product Insights",
        description = "Schema to hold product insights information"
)
@Data
public class ProductInsightDto {
    private Long id;
    private ProductClusters productClusters;
    private Triggers triggers;
    private String insight;
}
