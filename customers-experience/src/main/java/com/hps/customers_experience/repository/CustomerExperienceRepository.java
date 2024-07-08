package com.hps.customers_experience.repository;

import com.hps.customers_experience.entity.CustomerExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerExperienceRepository extends JpaRepository<CustomerExperience, String> {

    @Query(value = "SELECT ce.id, ce.customer_id, c.name AS customer_name, n.type AS need_type, m.type AS mission_type, " +
            "t.type AS touchpoint_type, jp.phase AS journey_phase, pop.type AS place_of_purchase " +
            "FROM customer_experiences ce " +
            "JOIN customers c ON ce.customer_id = c.id " +
            "JOIN needs n ON ce.need_id = n.id " +
            "JOIN missions m ON ce.mission_id = m.id " +
            "JOIN touchpoints t ON ce.touchpoint_id = t.id " +
            "JOIN journey_phases jp ON ce.journey_phase_id = jp.id " +
            "JOIN places_of_purchase pop ON ce.place_of_purchase_id = pop.id", nativeQuery = true)
    List<CustomerExperience> findAllCustomerExperiences();

    @Query(value = "SELECT ce.id, ce.customer_id, c.name AS customer_name, n.type AS need_type, m.type AS mission_type, " +
            "t.type AS touchpoint_type, jp.phase AS journey_phase, pop.type AS place_of_purchase " +
            "FROM customer_experiences ce " +
            "JOIN customers c ON ce.customer_id = c.id " +
            "JOIN needs n ON ce.need_id = n.id " +
            "JOIN missions m ON ce.mission_id = m.id " +
            "JOIN touchpoints t ON ce.touchpoint_id = t.id " +
            "JOIN journey_phases jp ON ce.journey_phase_id = jp.id " +
            "JOIN places_of_purchase pop ON ce.place_of_purchase_id = pop.id " +
            "WHERE ce.customer_id = ?1", nativeQuery = true)
    CustomerExperience findByCustomerId(String customerId);
}
