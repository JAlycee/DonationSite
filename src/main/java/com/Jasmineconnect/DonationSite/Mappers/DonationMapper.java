package com.Jasmineconnect.DonationSite.Mappers;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Entity.Donation;
public class DonationMapper {
    public static DonationDto toDto(Donation donation) {
        DonationDto donationDto = new DonationDto();
        donationDto.setId();
        donationDto.setAmount(donation.getAmount());
        // Map other fields
        return donationDto;
    }

    public static Donation toEntity(DonationDto donationDto) {
        Donation donation = new Donation();
        donation.setId(donationDto.getId());
        donation.setAmount(donationDto.getAmount());
        // Map other fields
        return donation;
    }
}
