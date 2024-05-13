package com.Jasmineconnect.DonationSite.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignDto {
    private Long id;
    private String name;
    private String description;
    private Double goalAmount;
}

