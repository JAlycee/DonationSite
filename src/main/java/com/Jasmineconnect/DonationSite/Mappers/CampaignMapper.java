package com.Jasmineconnect.DonationSite.Mappers;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;

public class CampaignMapper {
    public static CampaignDto toDto(Campaign campaign) {
        CampaignDto dto = new CampaignDto();
        dto.setId(campaign.getId());
        dto.setName(campaign.getName());
        dto.setDescription(campaign.getDescription());
        dto.setGoalAmount(campaign.getGoalAmount());
        dto.setAmountRaised(campaign.getAmountRaised());
        return dto;
    }

    public static Campaign campaignDtoToCampaign(CampaignDto dto) {
        Campaign campaign = new Campaign();
        campaign.setId(dto.getId());
        campaign.setName(dto.getName());
        campaign.setDescription(dto.getDescription());
        campaign.setGoalAmount(dto.getGoalAmount());
        campaign.setAmountRaised(dto.getAmountRaised());
        return campaign;
    }
}
