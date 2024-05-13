package com.Jasmineconnect.DonationSite.Service;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;

import java.util.List;
public interface DonationService {
        DonationDto makeDonation(DonationDto donationDto);
        List<DonationDto> getDonationsByUser(Long userId);
        List<DonationDto> getDonationsByCampaign(Long campaignId);
}

