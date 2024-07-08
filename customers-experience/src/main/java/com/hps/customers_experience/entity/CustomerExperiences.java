package com.hps.customers_experience.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerExperiences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "customer_id")
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "need_id", referencedColumnName = "id")
    private Needs needs;

    @ManyToOne
    @JoinColumn(name = "mission_id", referencedColumnName = "id")
    private Missions missions;

    @ManyToOne
    @JoinColumn(name = "touchpoint_id", referencedColumnName = "id")
    private Touchpoints touchpoints;

    @ManyToOne
    @JoinColumn(name = "journey_phase_id", referencedColumnName = "id")
    private JourneyPhases journeyPhases;

    @ManyToOne
    @JoinColumn(name = "place_of_purchase_id", referencedColumnName = "id")
    private PlacesOfPurchase placesOfPurchase;
}

