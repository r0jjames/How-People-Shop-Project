package com.hps.customers_experience.service;

import com.hps.customers_experience.dto.ProductInsightDto;

import java.util.List;

public interface IProductService {
    List<ProductInsightDto> getAllProductInsights();
}
