package com.Jasmineconnect.DonationSite.Mappers;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
public class CampaignMapper {

    public static CampaignDto toDto(Campaign campaign) {
        CampaignDto campaignDto = new CampaignDto();
        campaignDto.setId(campaign.getId());
        campaignDto.setName(campaign.getName());
        campaignDto.setDescription(campaign.getDescription());
        campaignDto.setGoalAmount(campaign.getGoalAmount());
        return campaignDto;
    }

    public static Campaign toEntity(CampaignDto campaignDto) {
        Campaign campaign = new Campaign();
        campaign.setId(campaignDto.getId());
        campaign.setName(campaignDto.getName());
        campaign.setDescription(campaignDto.getDescription());
        campaign.setGoalAmount(campaignDto.getGoalAmount());
        return campaign;
    }
}
