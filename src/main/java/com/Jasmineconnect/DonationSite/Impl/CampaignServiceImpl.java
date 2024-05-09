package com.Jasmineconnect.DonationSite.Impl;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
import com.Jasmineconnect.DonationSite.Mappers.CampaignMapper;
import com.Jasmineconnect.DonationSite.Repository.CampaignRepository;
import com.Jasmineconnect.DonationSite.Service.CampaignService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Component
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final CampaignMapper campaignMapper;

    public CampaignServiceImpl(CampaignRepository campaignRepository, CampaignMapper campaignMapper) {
        this.campaignRepository = campaignRepository;
        this.campaignMapper = campaignMapper;
    }

    @Override
    public CampaignDto createCampaign(CampaignDto campaignDto) {
        Campaign newCampaign = campaignMapper.convertToEntity(campaignDto);
        newCampaign = campaignRepository.save(newCampaign);
        return campaignMapper.convertToDTO(newCampaign);
    }

    @Override
    public Optional<CampaignDto> getCampaignById(Long id) {
        return campaignRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public Optional<CampaignDto> updateCampaignNameAndDescription(Long id, String name, String description) {
        return campaignRepository.findById(id).map(existingCampaign -> {
            existingCampaign.setName(name);
            existingCampaign.setDescription(description);
            existingCampaign = campaignRepository.save(existingCampaign);
            return convertToDTO(existingCampaign);
        });
    }

    @Override
    public Optional<CampaignDto> updateCampaign(Long id, CampaignDto campaignDto) {
        return campaignRepository.findById(id).map(existingCampaign -> {
            existingCampaign.setName(campaignDto.getName());
            existingCampaign.setDescription(campaignDto.getDescription());
            existingCampaign.setGoalAmount(campaignDto.getGoalAmount());
            existingCampaign.setStartDate(campaignDto.getStartDate());
            existingCampaign.setEndDate(campaignDto.getEndDate());
            existingCampaign = campaignRepository.save(existingCampaign);
            return convertToDTO(existingCampaign);
        });
    }

    @Override
    public List<CampaignDto> findAllCampaigns() {
        return campaignRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteCampaign(Long id) {
        return campaignRepository.findById(id).map(campaign -> {
            campaignRepository.delete(campaign);
            return true;
        }).orElse(false);
    }

    @Override
    public List<CampaignDto> findByGoalAmount(Double goalAmount) {
        return campaignRepository.findByGoalAmount(goalAmount)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CampaignDto> findByName(String name) {
        return campaignRepository.findByName(name)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CampaignDto convertToDTO(Campaign campaign) {
        return campaignMapper.convertToDTO(campaign);
    }
}

