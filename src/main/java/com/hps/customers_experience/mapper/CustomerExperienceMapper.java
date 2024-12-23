package com.hps.customers_experience.mapper;

import com.hps.customers_experience.dto.CustomerExperienceInsightsDto;
import com.hps.customers_experience.dto.CustomerExperiencesDto;
import com.hps.customers_experience.dto.ProductInsightDto;
import com.hps.customers_experience.entity.CustomerExperiences;
import com.hps.customers_experience.entity.CustomerExperienceInsights;
import com.hps.customers_experience.entity.ProductInsights;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerExperienceMapper {
    // Map from entity to DTO
    public static CustomerExperiencesDto mapToCustomerExperienceDto(CustomerExperiences entity) {
        CustomerExperiencesDto dto = new CustomerExperiencesDto();
        dto.setId(entity.getId());
        dto.setCustomerName(entity.getCustomers().getName());
        dto.setCustomerId(entity.getCustomers().getId());
        dto.setNeedType(entity.getNeeds().getType());
        dto.setMissionType(entity.getMissions().getType());
        dto.setTouchpointType(entity.getTouchpoints().getType());
        dto.setJourneyPhase(entity.getJourneyPhases().getPhase());
        dto.setPlaceOfPurchase(entity.getPlacesOfPurchase().getType());
        return dto;
    }

    public static CustomerExperienceInsightsDto mapToCustomerExperienceInsightDto(CustomerExperienceInsights entity) {
        CustomerExperienceInsightsDto dto = new CustomerExperienceInsightsDto();
        dto.setCustomerExperienceId(entity.getCustomerExperiences().getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public static ProductInsightDto mapToProductInsightDto(ProductInsights entity) {
        ProductInsightDto dto = new ProductInsightDto();
        dto.setId(entity.getId());
        dto.setProductClusters(entity.getProductClusters());
        dto.setTriggers(entity.getTriggers());
        dto.setInsight(entity.getInsight());
        return dto;
    }


    // Map from list of entities to list of DTOs
    public static List<CustomerExperiencesDto> mapToCustomerExperienceDtoList(List<CustomerExperiences> entities) {
        return entities.stream()
                .map(CustomerExperienceMapper::mapToCustomerExperienceDto)
                .collect(Collectors.toList());
    }

    public static List<ProductInsightDto> mapToProductInsightDtoList(List<ProductInsights> entities) {
        return entities.stream()
                .map(CustomerExperienceMapper::mapToProductInsightDto)
                .collect(Collectors.toList());
    }

    public static List<CustomerExperienceInsightsDto> mapToCustomerExperienceInsightDtoList(List<CustomerExperienceInsights> entities) {
        return entities.stream()
                .map(CustomerExperienceMapper::mapToCustomerExperienceInsightDto)
                .collect(Collectors.toList());
    }

}
