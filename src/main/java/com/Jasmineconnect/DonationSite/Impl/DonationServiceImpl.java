package com.Jasmineconnect.DonationSite.Impl;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Entity.Donation;
import com.Jasmineconnect.DonationSite.Mappers.DonationMapper;
import com.Jasmineconnect.DonationSite.Repository.DonationRepository;
import com.Jasmineconnect.DonationSite.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Override
    public DonationDto makeDonation(DonationDto donationDto) {
        Donation donation = DonationMapper.toEntity(donationDto); // Convert DTO to entity
        Donation savedDonation = donationRepository.save(donation);
        return DonationMapper.toDto(savedDonation); // Convert entity back to DTO
    }

    @Override
    public List<DonationDto> getDonationsByCampaign(Long campaignId) {
        List<Donation> donations = donationRepository.findByCampaignId(campaignId);
        return donations.stream()
                .map(DonationMapper::toDto) // Using the mapper method
                .collect(Collectors.toList());
    }

    @Override
    public List<DonationDto> getAllDonations() {
        List<Donation> donations = donationRepository.findAll();
        return donations.stream()
                .map(DonationMapper::toDto) // Using the mapper method
                .collect(Collectors.toList());
    }
}
