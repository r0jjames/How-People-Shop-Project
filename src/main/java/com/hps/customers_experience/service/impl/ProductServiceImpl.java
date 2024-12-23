package com.hps.customers_experience.service.impl;

import com.hps.customers_experience.dto.ProductInsightDto;
import com.hps.customers_experience.entity.ProductInsights;
import com.hps.customers_experience.mapper.CustomerExperienceMapper;
import com.hps.customers_experience.repository.ProductInsightsRepository;
import com.hps.customers_experience.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductInsightsRepository productInsightsRepository;

    @Override
    public List<ProductInsightDto> getAllProductInsights() {
        List<ProductInsights> productInsights = productInsightsRepository.findAll();
        return CustomerExperienceMapper.mapToProductInsightDtoList(productInsights);
    }
}
