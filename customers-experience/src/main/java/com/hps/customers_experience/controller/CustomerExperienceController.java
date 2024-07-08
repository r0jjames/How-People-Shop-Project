package com.hps.customers_experience.controller;

import com.hps.customers_experience.dto.CustomerExperienceInsightsDto;
import com.hps.customers_experience.dto.CustomerExperiencesDto;
import com.hps.customers_experience.service.ICustomerExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/customer", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerExperienceController {

    @Autowired
    private ICustomerExperienceService service;

    @GetMapping("/experiences")
    public ResponseEntity<List<CustomerExperiencesDto>> getAllExperiences() {
        List<CustomerExperiencesDto> customerExperiences = service.getAllExperiences();
        return ResponseEntity.ok(customerExperiences);
    }

//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<CustomerExperiencesDto> getExperiencesByCustomerId(@PathVariable Long customerId) {
//        CustomerExperiencesDto customerExperiences = service.getExperiencesByCustomerId(customerId);
//        return ResponseEntity.ok(customerExperiences);
//    }

    @GetMapping("/insights")
    public ResponseEntity<List<CustomerExperienceInsightsDto>> getAllCustomerExperienceInsights() {
        List<CustomerExperienceInsightsDto> customerExperienceInsightsDtoList = service.getAllCustomerExperienceInsights();
        return ResponseEntity.ok(customerExperienceInsightsDtoList);
    }
}