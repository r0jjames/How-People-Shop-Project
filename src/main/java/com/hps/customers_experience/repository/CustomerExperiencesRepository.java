package com.hps.customers_experience.repository;

import com.hps.customers_experience.entity.CustomerExperiences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerExperiencesRepository extends JpaRepository<CustomerExperiences, Long> {

}
