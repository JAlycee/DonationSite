package com.Jasmineconnect.DonationSite.mapper;

import com.Jasmineconnect.DonationSite.Entity.Campaign;
import com.Jasmineconnect.DonationSite.dto.CampaignDto;
import org.springframework.stereotype.Component;

@Component
public class CampaignMapper {

    public Campaign mapToCampaign(CampaignDto campaignDto) {
        Campaign campaign = new Campaign();
        campaign.setId(campaignDto.getId()); // Assuming id is set manually in DTO if needed
        campaign.setName(campaignDto.getName());
        campaign.setDescription(campaignDto.getDescription());
        campaign.setWants(campaignDto.isWants());
        campaign.setTotalDonations(campaignDto.getTotalDonations());
        campaign.setGoalAmount(campaignDto.getGoalAmount());
        campaign.setStartDate(campaignDto.getStartDate());
        campaign.setEndDate(campaignDto.getEndDate());
        return campaign;
    }

    public CampaignDto mapToCampaignDto(Campaign campaign) {
        CampaignDto campaignDto = new CampaignDto();
        campaignDto.setId(campaign.getId());
        campaignDto.setName(campaign.getName());
        campaignDto.setDescription(campaign.getDescription());
        campaignDto.setWants(campaign.isWants());
        campaignDto.setTotalDonations(campaign.getTotalDonations());
        campaignDto.setGoalAmount(campaign.getGoalAmount());
        campaignDto.setStartDate(campaign.getStartDate());
        campaignDto.setEndDate(campaign.getEndDate());
        return campaignDto;
    }
}

