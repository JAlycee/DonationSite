package com.Jasmineconnect.DonationSite.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonationDto {
    @Setter
    @Getter
    private Double amount;
    private String message;
    private Long selectedCampaignId; // Include the selected campaign ID field

    public void setId() {
    }

    public Long getId() {
        return null;
    }
}

