package com.Jasmineconnect.DonationSite.Impl;
import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
import com.Jasmineconnect.DonationSite.Entity.Donation;
import com.Jasmineconnect.DonationSite.Entity.User;
import com.Jasmineconnect.DonationSite.Mappers.DonationMapper;
import com.Jasmineconnect.DonationSite.Repository.CampaignRepository;
import com.Jasmineconnect.DonationSite.Repository.DonationRepository;
import com.Jasmineconnect.DonationSite.Repository.UserRepository;
import com.Jasmineconnect.DonationSite.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private DonationRepository donationRepository;
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public DonationDto makeDonation(DonationDto donationDto) {
        Donation donation = DonationMapper.donationDtoToDonation(donationDto);

        // Fetch and set the campaign
        Campaign campaign = campaignRepository.findById(donationDto.getCampaignId())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
        donation.setCampaign(campaign);

        // Fetch and set the user
        User user = userRepository.findById(donationDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        donation.setUser(user);

        // Update campaign's amount raised
        campaign.setAmountRaised(campaign.getAmountRaised() + donation.getAmount());
        campaignRepository.save(campaign);

        // Save the donation
        return DonationMapper.toDto(donationRepository.save(donation));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DonationDto> getDonationsByUser(Long userId) {
        return donationRepository.findAllByUserId(userId)
                .stream()
                .map(DonationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DonationDto> getDonationsByCampaign(Long campaignId) {
        return donationRepository.findAllByCampaignId(campaignId)
                .stream()
                .map(DonationMapper::toDto)
                .collect(Collectors.toList());
    }
}
