package com.Jasmineconnect.DonationSite.Mappers;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
import com.Jasmineconnect.DonationSite.Entity.Donation;

public class DonationMapper {
    public static DonationDto toDto(Donation donation) {
        DonationDto donationDto = new DonationDto();
        donationDto.setId(donation.getId());
        donationDto.setAmount(donation.getAmount());
        donationDto.setSelectedCampaignId(donation.getCampaign().getId());
        return donationDto;
    }

    public static Donation toEntity(DonationDto donationDto) {
        Donation donation = new Donation();
        donation.setId(donationDto.getId());  // Only set this for updates
        donation.setAmount(donationDto.getAmount());
        Campaign campaign = new Campaign();
        campaign.setId(donationDto.getSelectedCampaignId());
        donation.setCampaign(campaign);  // Set the campaign based on the ID
        return donation;
    }
}