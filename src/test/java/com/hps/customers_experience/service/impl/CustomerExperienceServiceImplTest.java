package com.hps.customers_experience.service.impl;

import com.hps.customers_experience.dto.CustomerExperienceInsightsDto;
import com.hps.customers_experience.dto.CustomerExperiencesDto;
import com.hps.customers_experience.entity.*;
import com.hps.customers_experience.repository.CustomerExperienceInsightsRepository;
import com.hps.customers_experience.repository.CustomerExperiencesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
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
        Customers customer1 = new Customers(1L, "Alice Johnson", "alice@example.com", "123-456-7890", 28, "Female", "New York");
        Needs need1 = new Needs(1L, "Replacement");
        Missions mission1 = new Missions(1L, "Solution Seeking");
        Touchpoints touchpoint1 = new Touchpoints(1L, "Brand Website");
        JourneyPhases phase1 = new JourneyPhases(1L, "Browsing");
        PlacesOfPurchase place1 = new PlacesOfPurchase(1L, "Store");

        Customers customer2 = new Customers(2L, "Bob Brown", "bob@example.com", "987-654-3210", 35, "Male", "Los Angeles");
        Needs need2 = new Needs(2L, "Upgrade");
        Missions mission2 = new Missions(2L, "Recreational Shopping");
        Touchpoints touchpoint2 = new Touchpoints(2L, "Store");
        JourneyPhases phase2 = new JourneyPhases(2L, "Filtering");
        PlacesOfPurchase place2 = new PlacesOfPurchase(2L, "Online");

        sampleExperiences = Arrays.asList(
                new CustomerExperiences(1L, customer1, need1, mission1, touchpoint1, phase1, place1),
                new CustomerExperiences(2L, customer2, need2, mission2, touchpoint2, phase2, place2)
        );

        // Data setup for CustomerExperienceInsights based on provided data
        sampleInsights = Arrays.asList(
                new CustomerExperienceInsights(1L, sampleExperiences.get(0), "Seamless Browsing Experience", "Customer found the online browsing experience seamless and intuitive."),
                new CustomerExperienceInsights(2L, sampleExperiences.get(1), "Overwhelmed by Options", "Customer felt overwhelmed by too many options at the store."),
                new CustomerExperienceInsights(3L, sampleExperiences.get(0), "Easy Product Comparison", "Comparing products on the brand website was easy and helpful."),
                new CustomerExperienceInsights(4L, sampleExperiences.get(1), "Long Wait Times", "Customer experienced long wait times during the committing phase at the store."),
                new CustomerExperienceInsights(5L, sampleExperiences.get(0), "Engaging Learning Phase", "Customer appreciated the learning phase videos on social media."),
                new CustomerExperienceInsights(6L, sampleExperiences.get(1), "Detailed Product Descriptions", "Customer found the product descriptions during the exploration phase very detailed and informative."),
                new CustomerExperienceInsights(7L, sampleExperiences.get(0), "Checkout Issues", "Customer experienced issues with the checkout process online."),
                new CustomerExperienceInsights(8L, sampleExperiences.get(1), "Interactive Exploration Phase", "Customer found the exploration phase in-store very interactive."),
                new CustomerExperienceInsights(9L, sampleExperiences.get(0), "Smooth Completion Phase", "Customer had a smooth completion phase with quick delivery online."),
                new CustomerExperienceInsights(10L, sampleExperiences.get(1), "Helpful Store Staff", "Customer appreciated the helpful staff during the store visit.")
        );
    }

    @Test
    public void testGetAllExperiences() {
        // Mocking repository behavior for CustomerExperiences
        when(customerExperiencesRepository.findAll()).thenReturn(sampleExperiences);

        List<CustomerExperiencesDto> experiencesList = customerExperienceService.getAllExperiences();

        // Assertions
        assertEquals(sampleExperiences.size(), experiencesList.size(), "Returned list size should match sample data size");

        // Additional assertions on each DTO
        for (int i = 0; i < sampleExperiences.size(); i++) {
            CustomerExperiencesDto dto = experiencesList.get(i);
            CustomerExperiences entity = sampleExperiences.get(i);
            assertEquals(entity.getId(), dto.getId(), "Experience IDs should match");
            assertEquals(entity.getCustomers().getName(), dto.getCustomerName(), "Customer names should match");
            assertEquals(entity.getNeeds().getType(), dto.getNeedType(), "Need types should match");
            assertEquals(entity.getMissions().getType(), dto.getMissionType(), "Mission types should match");
            assertEquals(entity.getTouchpoints().getType(), dto.getTouchpointType(), "Touchpoint types should match");
            assertEquals(entity.getJourneyPhases().getPhase(), dto.getJourneyPhase(), "Journey phases should match");
            assertEquals(entity.getPlacesOfPurchase().getType(), dto.getPlaceOfPurchase(), "Place of purchase types should match");
        }
    }

    @Test
    public void testGetAllCustomerExperienceInsights() {
        // Mocking repository behavior for CustomerExperienceInsights
        when(customerExperienceInsightsRepository.findAll()).thenReturn(sampleInsights);

        // Calling the service method
        List<CustomerExperienceInsightsDto> insightsList = customerExperienceService.getAllCustomerExperienceInsights();

        // Assertions
        int uniqueCustomerExperienceIds = sampleInsights.stream()
                .map(insights -> insights.getCustomerExperiences().getId())
                .collect(Collectors.toSet()).size();
        assertEquals(uniqueCustomerExperienceIds, insightsList.size(), "Returned list size should match number of unique customer experience IDs");

        for (CustomerExperienceInsightsDto dto : insightsList) {
            CustomerExperienceInsights matchingEntity = sampleInsights.stream()
                    .filter(insights -> insights.getCustomerExperiences().getId().equals(dto.getCustomerExperienceId()))
                    .findFirst().orElse(null);
            assert matchingEntity != null;
            assertEquals(matchingEntity.getTitle(), dto.getTitle(), "Title should match");
            assertEquals(matchingEntity.getDescription(), dto.getDescription(), "Description should match");
        }
    }
}
