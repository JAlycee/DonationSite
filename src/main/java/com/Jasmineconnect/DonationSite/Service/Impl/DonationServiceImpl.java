package com.Jasmineconnect.DonationSite.Service.Impl;
// Implement the methods defined in the DonationService interface. Use the DonationRepository to interact with the database. After creating a donation, call the email sending logic.// Implement the methods defined in the DonationService interface. Use the DonationRepository to interact with the database. After creating a donation, call the email sending logic.
import com.Jasmineconnect.DonationSite.Entity.Donation;
import com.Jasmineconnect.DonationSite.Repository.CampaignRepository;
import com.Jasmineconnect.DonationSite.Repository.DonationRepository;
import com.Jasmineconnect.DonationSite.Repository.UserRepository;
import com.Jasmineconnect.DonationSite.Service.DonationService;
import com.Jasmineconnect.DonationSite.dto.DonationDto;
import org.springframework.stereotype.Service;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;
    private final UserRepository userRepository;
    private final CampaignRepository campaignRepository;

    public DonationServiceImpl(DonationRepository donationRepository, UserRepository userRepository, CampaignRepository campaignRepository) {
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
        this.campaignRepository = campaignRepository;
    }

    @Override
    public DonationDto createDonation(DonationDto donationDto) {
        // Convert DonationDto to Donation entity
        Donation donation = new Donation();
        donation.setAmount(donationDto.getAmount());
        donation.setUser(userRepository.findById(donationDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found")));
        donation.setCampaign(campaignRepository.findById(donationDto.getCampaignId()).orElseThrow(() -> new RuntimeException("Campaign not found")));

        // Save the donation
        Donation savedDonation = donationRepository.save(donation);

        // Convert and return the saved donation DTO
        return mapToDonationDto(savedDonation);
    }

    @Override
    public DonationDto getDonationById(Long donationId) {
        Donation donation = donationRepository.findById(donationId)
                .orElseThrow(() -> new RuntimeException("Donation not found"));
        return mapToDonationDto(donation);
    }

    @Override
    public DonationDto updateDonation(Long donationId, DonationDto donationDto) {
        // Retrieve the existing donation
        Donation existingDonation = donationRepository.findById(donationId)
                .orElseThrow(() -> new RuntimeException("Donation not found"));

        // Update the existing donation with new data
        existingDonation.setAmount(donationDto.getAmount());

        // Save the updated donation
        Donation updatedDonation = donationRepository.save(existingDonation);

        // Return the updated donation DTO
        return mapToDonationDto(updatedDonation);
    }

    @Override
    public void deleteDonation(Long donationId) {
        // Check if the donation exists
        if (donationRepository.existsById(donationId)) {
            // Delete the donation
            donationRepository.deleteById(donationId);
        } else {
            throw new RuntimeException("Donation not found");
        }
    }

    // Helper method to map Donation entity to DonationDto
    private DonationDto mapToDonationDto(Donation donation) {
        DonationDto donationDto = new DonationDto();
        donationDto.setId(donation.getId());
        donationDto.setAmount(donation.getAmount());
        donationDto.setUserId(donation.getUser().getId());
        donationDto.setCampaignId(donation.getCampaign().getId());
        return donationDto;
    }
}
