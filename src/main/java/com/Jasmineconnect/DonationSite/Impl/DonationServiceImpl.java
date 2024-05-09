package com.Jasmineconnect.DonationSite.Impl;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
import com.Jasmineconnect.DonationSite.Entity.Donation;
import com.Jasmineconnect.DonationSite.Mappers.DonationMapper;
import com.Jasmineconnect.DonationSite.Repository.CampaignRepository;
import com.Jasmineconnect.DonationSite.Repository.DonationRepository;
import com.Jasmineconnect.DonationSite.Service.DonationService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Component
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;
    private final CampaignRepository campaignRepository;
    private final DonationMapper donationMapper;


    public DonationServiceImpl(DonationRepository donationRepository, CampaignRepository campaignRepository, DonationMapper donationMapper) {
        this.donationRepository = donationRepository;
        this.campaignRepository = campaignRepository;
        this.donationMapper = donationMapper;
    }

    @Override
    @Transactional
    public DonationDto createDonation(DonationDto donationDto) {
        Donation donation = donationMapper.convertToEntity(donationDto);
        donation.setCampaign(validateAndGetCampaign(donationDto.getCampaignId()));
        donation = donationRepository.save(donation);
        return donationMapper.convertToDTO(donation);
    }

    @Override
    public Optional<DonationDto> getDonationById(Long donationId) {
        return donationRepository.findById(donationId)
                .map(donationMapper::convertToDTO);
    }

    @Override
    public DonationDto updateDonation(Long donationId, DonationDto updatedDonationDto) {
        Donation existingDonation = donationRepository.findById(donationId)
                .orElseThrow(() -> new IllegalArgumentException("Donation not found"));
        existingDonation.setAmount(updatedDonationDto.getAmount());
        existingDonation.setMessage(updatedDonationDto.getMessage());
        existingDonation = donationRepository.save(existingDonation);
        return donationMapper.convertToDTO(existingDonation);
    }

    @Override
    public List<DonationDto> getAllDonations() {
        List<Donation> donations = donationRepository.findAll();
        return donations.stream()
                .map(donationMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDonation(Long donationId) {
        if (!donationRepository.existsById(donationId)) {
            throw new IllegalArgumentException("Donation not found");
        }
        donationRepository.deleteById(donationId);
    }

    private Campaign validateAndGetCampaign(Long campaignId) {
        return campaignRepository.findById(campaignId)
                .orElseThrow(() -> new IllegalArgumentException("Campaign not found with ID: " + campaignId));
    }
}

