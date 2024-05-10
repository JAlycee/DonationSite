package com.Jasmineconnect.DonationSite.Impl;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Entity.Donation;
import com.Jasmineconnect.DonationSite.Mappers.DonationMapper;
import com.Jasmineconnect.DonationSite.Repository.DonationRepository;
import com.Jasmineconnect.DonationSite.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Component
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;
    private final DonationMapper donationMapper;

    @Autowired
    public DonationServiceImpl(DonationRepository donationRepository, DonationMapper donationMapper) {
        this.donationRepository = donationRepository;
        this.donationMapper = donationMapper;
    }

    @Override
    public DonationDto createDonation(DonationDto donationDto) {
        Donation donation = donationMapper.dtoToEntity(donationDto);
        Donation savedDonation = donationRepository.save(donation);
        return donationMapper.entityToDto(savedDonation);
    }

    @Override
    public Optional<DonationDto> getDonationById(Long donationId) {
        Optional<Donation> donationOptional = donationRepository.findById(donationId);
        return donationOptional.map(donationMapper::entityToDto);
    }

    @Override
    public Optional<DonationDto> updateDonation(Long donationId, DonationDto updatedDonationDto) {
        Optional<Donation> existingDonationOptional = donationRepository.findById(donationId);
        if (existingDonationOptional.isPresent()) {
            Donation existingDonation = existingDonationOptional.get();
            donationMapper.updateEntityFromDto(updatedDonationDto, existingDonation);
            Donation updatedDonation = donationRepository.save(existingDonation);
            return Optional.of(donationMapper.entityToDto(updatedDonation));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<DonationDto> getAllDonations() {
        return null;
    }

    @Override
    public boolean deleteDonation(Long donationId) {
        if (donationRepository.existsById(donationId)) {
            donationRepository.deleteById(donationId);
            return true;
        }
        return false;
    }
    @Override
    public List<DonationDto> getDonationsByCampaignId(Long campaignId) {
        List<Donation> donations = donationRepository.findByCampaignId(campaignId);
        return donations.stream().map(donationMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<DonationDto> getDonationsByUserId(Long userId) {
        List<Donation> donations = donationRepository.findByUserId(userId);
        return donations.stream().map(donationMapper::entityToDto).collect(Collectors.toList());
    }

    // Additional methods for searching and filtering donations can be added here
}
//@Service
//public class DonationServiceImpl implements DonationService {
//
//    private final DonationRepository donationRepository;
//    private final DonationMapper donationMapper;
//
//    @Autowired
//    public DonationServiceImpl(DonationRepository donationRepository, DonationMapper donationMapper) {
//        this.donationRepository = donationRepository;
//        this.donationMapper = donationMapper;
//    }
//
//    @Override
//    public DonationDto createDonation(DonationDto donationDto) {
//        Donation donation = donationMapper.dtoToEntity(donationDto);
//        Donation savedDonation = donationRepository.save(donation);
//        return donationMapper.entityToDto(savedDonation);
//    }
//
//    @Override
//    public Optional<DonationDto> getDonationById(Long donationId) {
//        Optional<Donation> donationOptional = donationRepository.findById(donationId);
//        return donationOptional.map(donationMapper::entityToDto);
//    }
//
//    @Override
//    public DonationDto updateDonation(Long donationId, DonationDto updatedDonationDto) {
//        try {
//            Donation existingDonation = donationRepository.findById(donationId)
//                    .orElseThrow(ChangeSetPersister.NotFoundException::new);
//
//            // Update existingDonation with data from updatedDonationDto
//            existingDonation.setAmount(updatedDonationDto.getAmount());
//            existingDonation.setMessage(updatedDonationDto.getMessage());
//
//            Donation updatedDonation = donationRepository.save(existingDonation);
//            return donationMapper.entityToDto(updatedDonation);
//        } catch (ChangeSetPersister.NotFoundException ex) {
//            // Handle the exception gracefully, e.g., log it or return a default response
//            ex.printStackTrace(); // Example: printing the stack trace
//            return null; // Or return a custom response indicating the donation was not found
//        }
//    }
//
//    @Override
//    public boolean deleteDonation(Long donationId) {
//        if (donationRepository.existsById(donationId)) {
//            donationRepository.deleteById(donationId);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public List<DonationDto> getDonationsByCampaignId(Long campaignId) {
//        return null;
//    }
//
//    @Override
//    public List<DonationDto> getDonationsByUserId(Long userId) {
//        return null;
//    }
//
//    @Override
//    public List<DonationDto> getAllDonations() {
//        List<Donation> donations = donationRepository.findAll();
//        return donations.stream().map(donationMapper::entityToDto).collect(Collectors.toList());
//    }
