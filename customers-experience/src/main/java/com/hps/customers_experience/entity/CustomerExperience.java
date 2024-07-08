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
public class CustomerExperience {

    @Id
    private String id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "need_type")
    private String needType;

    @Column(name = "mission_type")
    private String missionType;

    @Column(name = "touchpoint_type")
    private String touchpointType;

    @Column(name = "journey_phase")
    private String journeyPhase;

    @Column(name = "place_of_purchase")
    private String placeOfPurchase;

    // Getters and setters...
}

