package com.Jasmineconnect.DonationSite.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "campaign")
@Accessors(chain = true)
public class Campaign extends AbstractEntity {

    private String name;
    private String description;
    private boolean wants;
    private double totalDonations;
    private double goalAmount;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}