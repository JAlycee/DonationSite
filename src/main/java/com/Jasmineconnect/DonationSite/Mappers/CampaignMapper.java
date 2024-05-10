package com.Jasmineconnect.DonationSite.Mappers;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CampaignMapper {

    public CampaignDto convertToDTO(Campaign campaign) {
        CampaignDto dto = new CampaignDto();
        dto.setId(campaign.getId());
        dto.setName(campaign.getName());
        dto.setDescription(campaign.getDescription());
        dto.setGoalAmount(campaign.getGoalAmount());
        dto.setStartDate(campaign.getStartDate());
        dto.setEndDate(campaign.getEndDate());
        return dto;
    }

    public Campaign convertToEntity(CampaignDto dto) {
        Campaign campaign = new Campaign();
        campaign.setId(dto.getId());
        campaign.setName(dto.getName());
        campaign.setDescription(dto.getDescription());
        campaign.setGoalAmount(dto.getGoalAmount());
        campaign.setStartDate(dto.getStartDate());
        campaign.setEndDate(dto.getEndDate());
        return campaign;
    }

    public void updateEntityFromDto(CampaignDto updatedCampaignDto, Campaign existingCampaign) {
        // Update existingCampaign with data from updatedCampaignDto
        existingCampaign.setName(updatedCampaignDto.getName());
        existingCampaign.setDescription(updatedCampaignDto.getDescription());
        existingCampaign.setGoalAmount(updatedCampaignDto.getGoalAmount());
        existingCampaign.setStartDate(updatedCampaignDto.getStartDate());
        existingCampaign.setEndDate(updatedCampaignDto.getEndDate());
    }

    public List<CampaignDto> entitiesToDtos(List<Campaign> campaigns) {
        return campaigns.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CampaignDto entityToDto(Campaign savedCampaign) {
        return convertToDTO(savedCampaign);
    }
    public Campaign dtoToEntity(CampaignDto dto) {
        Campaign campaign = new Campaign();
        campaign.setId(dto.getId());
        campaign.setName(dto.getName());
        campaign.setDescription(dto.getDescription());
        campaign.setGoalAmount(dto.getGoalAmount());
        campaign.setStartDate(dto.getStartDate());
        campaign.setEndDate(dto.getEndDate());
        return campaign;
    }
}
