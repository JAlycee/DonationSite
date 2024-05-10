package com.Jasmineconnect.DonationSite.Mappers;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Dto.UserDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
import com.Jasmineconnect.DonationSite.Entity.Donation;
import com.Jasmineconnect.DonationSite.Entity.User;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class DonationMapper {

    public DonationDto entityToDto(Donation donation) {
        DonationDto dto = new DonationDto();
        dto.setId(donation.getId());
        dto.setAmount(donation.getAmount());
        dto.setCampaignId(donation.getCampaign().getId());
        dto.setMessage(donation.getMessage());
        return dto;
    }

    public Donation dtoToEntity(DonationDto dto) {
        Donation donation = new Donation();
        donation.setId(dto.getId());
        donation.setAmount(dto.getAmount());
        donation.setMessage(dto.getMessage());
        // Set campaign and user entities
        if (dto.getCampaignDto() != null) {
            donation.setCampaign(convertCampaignDtoToEntity(dto.getCampaignDto()));
        }
        if (dto.getUserDto() != null) {
            donation.setUser(convertUserDtoToEntity(dto.getUserDto()));
        }
        return donation;
    }

    private CampaignDto convertCampaignToDto(Campaign campaign) {
        CampaignDto dto = new CampaignDto();
        dto.setId(campaign.getId());
        dto.setName(campaign.getName());
        dto.setDescription(campaign.getDescription());
        dto.setGoalAmount(campaign.getGoalAmount());
        dto.setStartDate(campaign.getStartDate());
        dto.setEndDate(campaign.getEndDate());
        return dto;
    }

    private Campaign convertCampaignDtoToEntity(CampaignDto dto) {
        Campaign campaign = new Campaign();
        campaign.setId(dto.getId());
        campaign.setName(dto.getName());
        campaign.setDescription(dto.getDescription());
        campaign.setGoalAmount(dto.getGoalAmount());
        campaign.setStartDate(dto.getStartDate());
        campaign.setEndDate(dto.getEndDate());
        return campaign;
    }

    private UserDto convertUserToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        // Map other fields as needed
        return dto;
    }

    private User convertUserDtoToEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        // Map other fields as needed
        return user;
    }

    public void updateEntityFromDto(DonationDto updatedDonationDto, Donation existingDonation) {
        // Update existingDonation with data from updatedDonationDto
        existingDonation.setAmount(updatedDonationDto.getAmount());
        existingDonation.setMessage(updatedDonationDto.getMessage());
        // Update campaign and user entities if necessary
        if (updatedDonationDto.getCampaignDto() != null) {
            existingDonation.setCampaign(convertCampaignDtoToEntity(updatedDonationDto.getCampaignDto()));
        }
        if (updatedDonationDto.getUserDto() != null) {
            existingDonation.setUser(convertUserDtoToEntity(updatedDonationDto.getUserDto()));
        }
    }
}
