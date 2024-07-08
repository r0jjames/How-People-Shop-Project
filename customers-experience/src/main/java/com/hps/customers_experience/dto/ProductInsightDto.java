package com.hps.customers_experience.dto;

import com.hps.customers_experience.entity.ProductClusters;
import com.hps.customers_experience.entity.Triggers;
import lombok.*;


@Data
public class ProductInsightDto {
    private Long id;
    private ProductClusters productClusters;
    private Triggers triggers;
    private String insight;
}
