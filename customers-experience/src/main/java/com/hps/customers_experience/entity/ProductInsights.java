package com.hps.customers_experience.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInsights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_cluster_id", referencedColumnName = "id")
    private ProductClusters productClusters;

    @ManyToOne
    @JoinColumn(name = "trigger_id", referencedColumnName = "id")
    private Triggers triggers;

    private String insight;
}

