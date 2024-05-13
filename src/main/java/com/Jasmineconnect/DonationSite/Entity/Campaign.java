package com.Jasmineconnect.DonationSite.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double goalAmount;
    private Double amountRaised = 0.0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}