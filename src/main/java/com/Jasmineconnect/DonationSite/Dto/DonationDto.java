package com.Jasmineconnect.DonationSite.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonationDto {
    private Long id;
    private Double amount;
    private String message;
    private Long selectedCampaignId;
}
