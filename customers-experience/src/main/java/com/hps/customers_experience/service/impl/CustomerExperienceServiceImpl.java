package com.hps.customers_experience.service.impl;

import com.hps.customers_experience.dto.CustomerExperienceInsightsDto;
import com.hps.customers_experience.dto.CustomerExperiencesDto;
import com.hps.customers_experience.entity.CustomerExperiences;
import com.hps.customers_experience.entity.CustomerExperienceInsights;
import com.hps.customers_experience.mapper.CustomerExperienceMapper;
import com.hps.customers_experience.repository.CustomerExperienceInsightsRepository;
import com.hps.customers_experience.repository.CustomerExperiencesRepository;
import com.hps.customers_experience.service.ICustomerExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerExperienceServiceImpl implements ICustomerExperienceService {

    private final CustomerExperiencesRepository customerExperiencesRepository;
    private final CustomerExperienceInsightsRepository customerExperienceInsightsRepository;

    @Override
    public List<CustomerExperiencesDto> getAllExperiences() {
        List<CustomerExperiences> customerExperiences = customerExperiencesRepository.findAll();
        return CustomerExperienceMapper.mapToCustomerExperienceDtoList(customerExperiences);
    }


    @Override
    public List<CustomerExperienceInsightsDto> getAllCustomerExperienceInsights() {
        List<CustomerExperienceInsights> customerExperienceInsights = customerExperienceInsightsRepository.findAll();
        return CustomerExperienceMapper.mapToCustomerExperienceInsightDtoList(customerExperienceInsights);
    }

    @Override
    public List<CustomerExperienceInsightsDto> getAllDistinctCustomerExperienceInsights() {
        List<String> distinctInsights = customerExperienceInsightsRepository.findAllDistinctInsights();
        return distinctInsights.stream()
                .map(CustomerExperienceInsightsDto::new)
                .collect(Collectors.toList());
    }

}
