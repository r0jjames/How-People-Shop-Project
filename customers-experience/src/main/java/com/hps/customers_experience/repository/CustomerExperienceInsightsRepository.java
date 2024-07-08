package com.hps.customers_experience.repository;

import com.hps.customers_experience.entity.CustomerExperienceInsights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerExperienceInsightsRepository extends JpaRepository<CustomerExperienceInsights, Long> {

}