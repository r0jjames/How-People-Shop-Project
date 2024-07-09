package com.hps.customers_experience.repository;

import com.hps.customers_experience.entity.CustomerExperienceInsights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerExperienceInsightsRepository extends JpaRepository<CustomerExperienceInsights, Long> {
    @Query("SELECT DISTINCT cei.insight FROM CustomerExperienceInsights cei")
    List<String> findAllDistinctInsights();

}