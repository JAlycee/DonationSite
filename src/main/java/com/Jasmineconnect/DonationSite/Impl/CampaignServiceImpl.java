package com.Jasmineconnect.DonationSite.Impl;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
import com.Jasmineconnect.DonationSite.Mappers.CampaignMapper;
import com.Jasmineconnect.DonationSite.Repository.CampaignRepository;
import com.Jasmineconnect.DonationSite.Service.CampaignService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    public CampaignDto createCampaign(CampaignDto campaignDto) {
        // Logic to map the DTO to an entity, save it to the database, and return the DTO
        Campaign campaign = CampaignMapper.toEntity(campaignDto);
        Campaign savedCampaign = campaignRepository.save(campaign);
        return CampaignMapper.toDto(savedCampaign);
    }

    @Override
    public CampaignDto updateCampaign(Long id, CampaignDto campaignDto) {
        Campaign existingCampaign = campaignRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Campaign not found with id: " + id));
        existingCampaign.setName(campaignDto.getName());
        existingCampaign.setDescription(campaignDto.getDescription());
        // Update other fields as needed
        Campaign updatedCampaign = campaignRepository.save(existingCampaign);
        return mapEntityToDto(updatedCampaign);
    }

    @Override
    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }

    @Override
    public CampaignDto getCampaignById(Long id) {
        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Campaign not found with id: " + id));
        return mapEntityToDto(campaign);
    }

    @Override
    public List<CampaignDto> getAllCampaigns() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return campaigns.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CampaignDto> searchCampaignsByName(String name) {
        List<Campaign> campaigns = campaignRepository.findByNameContainingIgnoreCase(name);
        return campaigns.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    private CampaignDto mapEntityToDto(Campaign campaign) {
        CampaignDto campaignDto = new CampaignDto();
        campaignDto.setId(campaign.getId());
        campaignDto.setName(campaign.getName());
        campaignDto.setDescription(campaign.getDescription());
        // Map other fields as needed
        return campaignDto;
    }

    private Campaign mapDtoToEntity(CampaignDto campaignDto) {
        Campaign campaign = new Campaign();
        campaign.setName(campaignDto.getName());
        campaign.setDescription(campaignDto.getDescription());
        // Map other fields as needed
        return campaign;
    }
}
