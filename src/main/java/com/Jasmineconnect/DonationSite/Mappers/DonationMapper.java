package com.Jasmineconnect.DonationSite.Mappers;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Entity.Donation;

public class DonationMapper {

    public static DonationDto toDto(Donation donation) {
        DonationDto dto = new DonationDto();
        dto.setId(donation.getId());
        dto.setAmount(donation.getAmount());
        dto.setMessage(donation.getMessage());
        dto.setCampaignId(donation.getCampaign() != null ? donation.getCampaign().getId() : null);
        dto.setUserId(donation.getUser() != null ? donation.getUser().getId() : null);
        return dto;
    }

    public static Donation donationDtoToDonation(DonationDto dto) {
        Donation donation = new Donation();
        donation.setId(dto.getId()); // Assuming ID is only set for updates, not for new donations
        donation.setAmount(dto.getAmount());
        donation.setMessage(dto.getMessage());
        // Note: User and Campaign should be set in the service layer as they require fetching from the database
        return donation;
    }
}
