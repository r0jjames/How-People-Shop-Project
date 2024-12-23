package com.hps.customers_experience.controller;

import com.hps.customers_experience.dto.CustomerExperienceInsightsDto;
import com.hps.customers_experience.dto.CustomerExperiencesDto;
import com.hps.customers_experience.service.ICustomerExperienceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "Customers Experience API", description = "Provide analytics and insights related to customers experience")
@RestController
@RequestMapping(path = "/api/customers", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerExperienceController {

    @Autowired
    private ICustomerExperienceService service;

    @GetMapping("/experiences")
    public ResponseEntity<List<CustomerExperiencesDto>> getAllExperiences() {
        List<CustomerExperiencesDto> customerExperiences = service.getAllExperiences();
        return ResponseEntity.ok(customerExperiences);
    }

    @GetMapping("/insights")
    public ResponseEntity<List<CustomerExperienceInsightsDto>> getAllCustomerExperienceInsights() {
        List<CustomerExperienceInsightsDto> insightsDtoList = service.getAllCustomerExperienceInsights();
        return ResponseEntity.ok(insightsDtoList);
    }

}