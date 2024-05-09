package com.Jasmineconnect.DonationSite.Mappers;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Entity.Donation;
import org.springframework.stereotype.Component;

@Component
public class DonationMapper {

    // Correct the parameter type from Long to Donation
    public DonationDto convertToDTO(Donation donation) {
        DonationDto dto = new DonationDto();
        dto.setId(donation.getId());
        dto.setAmount(donation.getAmount());
        dto.setMessage(donation.getMessage());
        dto.setCampaignId(donation.getCampaign() != null ? donation.getCampaign().getId() : null);
        return dto;
    }

    public Donation convertToEntity(DonationDto dto) {
        Donation donation = new Donation();
        donation.setId(dto.getId());
        donation.setAmount(dto.getAmount());
        donation.setMessage(dto.getMessage());
        // Assuming Campaign is set elsewhere using the campaignId
        return donation;
    }
}
