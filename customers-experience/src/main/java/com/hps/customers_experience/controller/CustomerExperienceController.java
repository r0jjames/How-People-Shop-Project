package com.hps.customers_experience.controller;

import com.hps.customers_experience.dto.CustomerExperiencesDto;
import com.hps.customers_experience.service.ICustomerExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/experiences", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerExperienceController {

    @Autowired
    private ICustomerExperienceService service;

    @GetMapping
    public ResponseEntity<List<CustomerExperiencesDto>> getAllExperiences() {
        List<CustomerExperiencesDto> customerExperiences = service.getAllExperiences();
        return ResponseEntity.ok(customerExperiences);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerExperiencesDto> getExperiencesByCustomerId(@PathVariable String customerId) {
        CustomerExperiencesDto customerExperiences = service.getExperiencesByCustomerId(customerId);
        return ResponseEntity.ok(customerExperiences);
    }
}