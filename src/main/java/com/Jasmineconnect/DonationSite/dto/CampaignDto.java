package com.Jasmineconnect.DonationSite.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class CampaignDto {
    private Long id;
    private String name;
    private String description;
    private boolean isWants;
    private double totalDonations;
    private double goalAmount;
    private Date startDate;
    private Date endDate;
}

