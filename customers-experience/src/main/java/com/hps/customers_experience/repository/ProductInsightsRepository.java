package com.hps.customers_experience.repository;

import com.hps.customers_experience.entity.ProductInsights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInsightsRepository extends JpaRepository<ProductInsights, Long> {
}
