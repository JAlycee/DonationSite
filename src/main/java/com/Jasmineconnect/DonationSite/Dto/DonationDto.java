package com.Jasmineconnect.DonationSite.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonationDto {
    private Long id;
    private Double amount;
    private Long campaignId;
    private String message;

    @JsonIgnore
    private CampaignDto campaignDto; // Exclude campaignDto from serialization

    @JsonIgnore
    private UserDto userDto; // Exclude userDto from serialization

    public DonationDto() {
    }
}

