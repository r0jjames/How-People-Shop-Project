package com.hps.customers_experience.service.impl;

import com.hps.customers_experience.dto.CustomerExperienceInsightsDto;
import com.hps.customers_experience.dto.CustomerExperiencesDto;
import com.hps.customers_experience.entity.*;
import com.hps.customers_experience.repository.CustomerExperienceInsightsRepository;
import com.hps.customers_experience.repository.CustomerExperiencesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerExperienceServiceImplTest {
    @Mock
    private CustomerExperiencesRepository customerExperiencesRepository;

    @Mock
    private CustomerExperienceInsightsRepository customerExperienceInsightsRepository;

    @InjectMocks
    private CustomerExperienceServiceImpl customerExperienceService;

    private List<CustomerExperiences> sampleExperiences;
    private List<CustomerExperienceInsights> sampleInsights;

    @BeforeEach
    public void setUp() {
        customerExperiencesRepository = Mockito.mock(CustomerExperiencesRepository.class);
        customerExperienceInsightsRepository = Mockito.mock(CustomerExperienceInsightsRepository.class);
        customerExperienceService = new CustomerExperienceServiceImpl(customerExperiencesRepository, customerExperienceInsightsRepository);

        // Sample data setup
        Customers customer1 = new Customers();
        customer1.setId(1L);
        customer1.setName("Alice Johnson");
        Needs need1 = new Needs(1L, "Replacement");
        Missions mission1 = new Missions(1L, "Solution Seeking");
        Touchpoints touchpoint1 = new Touchpoints(1L, "Brand Website");
        JourneyPhases phase1 = new JourneyPhases(1L, "Browsing");
        PlacesOfPurchase place1 = new PlacesOfPurchase(1L, "Store");

        Customers customer2 = new Customers();
        customer2.setId(2L);
        customer2.setName("Bob Brown");
        Needs need2 = new Needs(2L, "Upgrade");
        Missions mission2 = new Missions(2L, "Recreational Shopping");
        Touchpoints touchpoint2 = new Touchpoints(2L, "Store");
        JourneyPhases phase2 = new JourneyPhases(2L, "Filtering");
        PlacesOfPurchase place2 = new PlacesOfPurchase(2L, "Online");

        sampleExperiences = Arrays.asList(
                new CustomerExperiences(1L, customer1, need1, mission1, touchpoint1, phase1, place1),
                new CustomerExperiences(2L, customer2, need2, mission2, touchpoint2, phase2, place2)
                // Add more sample data as needed
        );

        // Sample data setup for CustomerExperienceInsights
        sampleInsights = Arrays.asList(
                new CustomerExperienceInsights(1L, sampleExperiences.get(0), "Customer found the online browsing experience seamless and intuitive."),
                new CustomerExperienceInsights(2L, sampleExperiences.get(1), "Customer felt overwhelmed by too many options at the store.")
                // Add more sample insights as needed
        );
    }

    @Test
    public void testGetAllExperiences() {
        // Mocking repository behavior for CustomerExperiences
        when(customerExperiencesRepository.findAll()).thenReturn(sampleExperiences);

        // Calling the service method
        List<CustomerExperiencesDto> experiencesList = customerExperienceService.getAllExperiences();

        // Assertions
        assertEquals(sampleExperiences.size(), experiencesList.size(), "Returned list size should match sample data size");

    }

    @Test
    public void testGetAllCustomerExperienceInsights() {
        // Mocking repository behavior for CustomerExperienceInsights
        when(customerExperienceInsightsRepository.findAll()).thenReturn(sampleInsights);

        // Calling the service method
        List<CustomerExperienceInsightsDto> insightsList = customerExperienceService.getAllCustomerExperienceInsights();

        // Assertions
        assertEquals(sampleInsights.size(), insightsList.size(), "Returned list size should match sample insights size");
        // Additional assertions on each DTO
        for (int i = 0; i < sampleInsights.size(); i++) {
            CustomerExperienceInsightsDto dto = insightsList.get(i);
            CustomerExperienceInsights entity = sampleInsights.get(i);
            assertEquals(entity.getInsight(), dto.getInsight(), "Insight texts should match");
            // Add more assertions as needed
        }
    }

}
