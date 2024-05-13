package com.Jasmineconnect.DonationSite.Mappers;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Entity.Donation;
public class DonationMapper {

    public static DonationDto toDto(Donation donation) {
        if (donation == null) {
            return null;
        }
        DonationDto dto = new DonationDto();
        dto.setId(donation.getId());
        dto.setAmount(donation.getAmount());
        dto.setMessage(donation.getMessage());
        dto.setCampaignId(donation.getCampaign() != null ? donation.getCampaign().getId() : null);
        dto.setUserId(donation.getUser() != null ? donation.getUser().getId() : null);
        return dto;
    }

    public static Donation donationDtoToDonation(DonationDto dto) {
        if (dto == null) {
            return null;
        }
        Donation donation = new Donation();
        donation.setId(dto.getId());  // Assume set for update operations
        donation.setAmount(dto.getAmount());
        donation.setMessage(dto.getMessage());
        // User and Campaign need to be set in the service layer as they require fetching from the database
        return donation;
    }
}


