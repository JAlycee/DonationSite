package com.Jasmineconnect.DonationSite.Service;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DonationService {
        DonationDto createDonation(DonationDto donationDto);
        Optional<DonationDto> getDonationById(Long donationId);
        DonationDto updateDonation(Long donationId, DonationDto updatedDonationDto);
        List<DonationDto> getAllDonations();
        void deleteDonation(Long donationId);
    }
//    private final DonationRepository donationRepository;
//    private final CampaignRepository campaignRepository;
//    private final DonationMapper donationMapper;
//
//    @Autowired
//    public DonationService(DonationRepository donationRepository, CampaignRepository campaignRepository, DonationMapper donationMapper) {
//        this.donationRepository = donationRepository;
//        this.campaignRepository = campaignRepository;
//        this.donationMapper = donationMapper;
//    }
//    public DonationDto createDonation(DonationDto donationDto) {
//        Donation donation = donationMapper.convertToEntity(donationDto);
//        donation = donationRepository.save(donation);
//        return donationMapper.convertToDTO(donation);
//    }
////    public DonationDto createDonation(DonationDto donationDto) {
////        // Ensure that the donation is associated with a campaign
////        Campaign campaign = campaignRepository.findById(donationDto.getCampaignId())
////                .orElseThrow(() -> new IllegalArgumentException("Campaign not found"));
////
////        // Map DonationDto to Donation entity
////        Donation donation = new Donation();
////        donation.setAmount(donationDto.getAmount());
////        donation.setMessage(donationDto.getMessage());
////        donation.setCampaign(campaign);
////
////        // Save the donation
////        Donation savedDonation = donationRepository.save(donation);
////
////        // Update the total donations for the associated campaign
////        campaign.addToDonationTotal(donation.getAmount());
////        campaignRepository.save(campaign);
////
////        // Update total donations for all campaigns
////        updateTotalDonationsForAllCampaigns();
////
////        // Map saved Donation entity back to DonationDto
////        return mapToDto(savedDonation);
////    }
//
//    private void updateTotalDonationsForAllCampaigns() {
//        List<Campaign> campaigns = campaignRepository.findAll();
//        for (Campaign campaign : campaigns) {
//            double totalDonations = donationRepository.getTotalDonationsForCampaign(campaign.getId());
//            campaign.setTotalDonations(totalDonations);
//            campaignRepository.save(campaign);
//        }
//    }
//
//    public DonationDto getDonationById(Long donationId) {
//        Donation donation = donationRepository.findById(donationId)
//                .orElseThrow(() -> new IllegalArgumentException("Donation not found"));
//        return mapToDto(donation);
//    }
//
//    public DonationDto updateDonation(Long donationId, DonationDto updatedDonationDto) {
//        Donation existingDonation = donationRepository.findById(donationId)
//                .orElseThrow(() -> new IllegalArgumentException("Donation not found"));
//
//        existingDonation.setAmount(updatedDonationDto.getAmount());
//        existingDonation.setMessage(updatedDonationDto.getMessage());
//
//        Donation updatedDonation = donationRepository.save(existingDonation);
//
//        // Update total donations for the associated campaign
//        updateCampaignTotalDonations(updatedDonation.getCampaign());
//
//        return mapToDto(updatedDonation);
//    }
//
//    private void updateCampaignTotalDonations(Campaign campaign) {
//        double totalDonations = donationRepository.getTotalDonationsForCampaign(campaign.getId());
//        campaign.setTotalDonations(totalDonations);
//        campaignRepository.save(campaign);
//    }
//
//    private Campaign validateAndGetCampaign(Long campaignId) {
//        return campaignRepository.findById(campaignId)
//                .orElseThrow(() -> new IllegalArgumentException("Campaign not found with ID:" + campaignId));
//    }
//
//    public List<DonationDto> getAllDonations() {
//        List<Donation> donations = donationRepository.findAll();
//        return donations.stream().map(this::mapToDto).collect(Collectors.toList());
//    }
//
//    private DonationDto mapToDto(Donation donation) {
//        DonationDto donationDto = new DonationDto();
//        donationDto.setId(donation.getId());
//        donationDto.setAmount(donation.getAmount());
//        donationDto.setMessage(donation.getMessage());
//        if (donation.getCampaign() != null) {
//            donationDto.setCampaignId(donation.getCampaign().getId());
//        }
//        return donationDto;
//    }
//
//
//    public void deleteDonation(Long donationId) {
//        if (!donationRepository.existsById(donationId)) {
//            throw new IllegalArgumentException("Donation not found");
//        }
//        donationRepository.deleteById(donationId);
//    }
//}
