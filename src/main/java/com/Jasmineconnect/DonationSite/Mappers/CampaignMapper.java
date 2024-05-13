package com.Jasmineconnect.DonationSite.Mappers;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
public class CampaignMapper {
    public static CampaignDto toDto(Campaign campaign) {
        CampaignDto dto = new CampaignDto();
        dto.setId(campaign.getId());
        dto.setName(campaign.getName());
        dto.setDescription(campaign.getDescription());
        // Add other fields as necessary
        return dto;
    }

    public static Campaign toEntity(CampaignDto campaignDto) {
        Campaign campaign = new Campaign();
        campaign.setId(campaignDto.getId());  // Set ID if updating an existing entity
        campaign.setName(campaignDto.getName());
        campaign.setDescription(campaignDto.getDescription());
        // Map additional fields as needed
        return campaign;
    }
}