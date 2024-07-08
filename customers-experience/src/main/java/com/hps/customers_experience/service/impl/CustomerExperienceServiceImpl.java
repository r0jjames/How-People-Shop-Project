package com.hps.customers_experience.service.impl;

import com.hps.customers_experience.dto.CustomerExperiencesDto;
import com.hps.customers_experience.entity.CustomerExperience;
import com.hps.customers_experience.mapper.CustomerExperienceMapper;
import com.hps.customers_experience.repository.CustomerExperienceRepository;
import com.hps.customers_experience.service.ICustomerExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerExperienceServiceImpl implements ICustomerExperienceService {

    private CustomerExperienceRepository repository;

    @Override
    public List<CustomerExperiencesDto> getAllExperiences() {
        List<CustomerExperience> customerExperiences = repository.findAllCustomerExperiences();
        return CustomerExperienceMapper.mapToCustomerExperienceDtoList(customerExperiences);
    }

    @Override
    public CustomerExperiencesDto getExperiencesByCustomerId(String customerId) {
        CustomerExperience customerExperiences = repository.findByCustomerId(customerId);
        return CustomerExperienceMapper.mapToCustomerExperienceDto(customerExperiences);
    }

}
