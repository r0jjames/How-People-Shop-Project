package com.hps.customers_experience.mapper;

import com.hps.customers_experience.dto.CustomerExperiencesDto;
import com.hps.customers_experience.entity.CustomerExperience;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerExperienceMapper {
    // Map from entity to DTO
    public static CustomerExperiencesDto mapToCustomerExperienceDto(CustomerExperience entity) {
        CustomerExperiencesDto dto = new CustomerExperiencesDto();
        dto.setId(entity.getId());
        dto.setCustomerId(entity.getCustomerId());
        dto.setCustomerName(entity.getCustomerName());
        dto.setNeedType(entity.getNeedType());
        dto.setMissionType(entity.getMissionType());
        dto.setTouchpointType(entity.getTouchpointType());
        dto.setJourneyPhase(entity.getJourneyPhase());
        dto.setPlaceOfPurchase(entity.getPlaceOfPurchase());
        return dto;
    }

    // Map from DTO to entity
    public static CustomerExperience mapToCustomerExperience(CustomerExperiencesDto dto) {
        CustomerExperience entity = new CustomerExperience();
        entity.setId(dto.getId());
        entity.setCustomerId(dto.getCustomerId());
        entity.setCustomerName(dto.getCustomerName());
        entity.setNeedType(dto.getNeedType());
        entity.setMissionType(dto.getMissionType());
        entity.setTouchpointType(dto.getTouchpointType());
        entity.setJourneyPhase(dto.getJourneyPhase());
        entity.setPlaceOfPurchase(dto.getPlaceOfPurchase());
        return entity;
    }

    // Map from list of entities to list of DTOs
    public static List<CustomerExperiencesDto> mapToCustomerExperienceDtoList(List<CustomerExperience> entities) {
        return entities.stream()
                .map(CustomerExperienceMapper::mapToCustomerExperienceDto)
                .collect(Collectors.toList());
    }

    // Map from list of DTOs to list of entities
    public static List<CustomerExperience> mapToCustomerExperienceList(List<CustomerExperiencesDto> dtos) {
        return dtos.stream()
                .map(CustomerExperienceMapper::mapToCustomerExperience)
                .collect(Collectors.toList());
    }
}
