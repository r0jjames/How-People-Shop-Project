package com.hps.customers_experience.service;


import com.hps.customers_experience.dto.CustomerExperiencesDto;
import java.util.List;

public interface ICustomerExperienceService {

    List<CustomerExperiencesDto> getAllExperiences();
    CustomerExperiencesDto getExperiencesByCustomerId(String customerId);
}
