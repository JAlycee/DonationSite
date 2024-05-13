package com.Jasmineconnect.DonationSite.Impl;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
import com.Jasmineconnect.DonationSite.Entity.User;
import com.Jasmineconnect.DonationSite.Mappers.CampaignMapper;
import com.Jasmineconnect.DonationSite.Repository.CampaignRepository;
import com.Jasmineconnect.DonationSite.Repository.UserRepository;
import com.Jasmineconnect.DonationSite.Service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public CampaignDto createCampaign(CampaignDto campaignDto) {
        Campaign campaign = CampaignMapper.campaignDtoToCampaign(campaignDto);
        // Retrieve the user with the ID provided in DTO
        User user = userRepository.findById(campaignDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        campaign.setUser(user);
        // Save the campaign and return the DTO with data from the saved entity
        return CampaignMapper.toDto(campaignRepository.save(campaign));
    }

    @Override
    @Transactional
    public CampaignDto updateCampaign(Long id, CampaignDto updatedCampaign) {
        Campaign campaign = campaignRepository.findById(id).orElseThrow(() -> new RuntimeException("Campaign not found"));
        campaign.setName(updatedCampaign.getName());
        campaign.setDescription(updatedCampaign.getDescription());
        campaign.setGoalAmount(updatedCampaign.getGoalAmount());
        campaign.setAmountRaised(updatedCampaign.getAmountRaised());
        return CampaignMapper.toDto(campaignRepository.save(campaign));
    }

    @Override
    @Transactional
    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CampaignDto getCampaignById(Long id) {
        Campaign campaign = campaignRepository.findById(id).orElseThrow(() -> new RuntimeException("Campaign not found"));
        return CampaignMapper.toDto(campaign);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CampaignDto> searchCampaignsByName(String name) {
        return campaignRepository.findByNameContaining(name).stream().map(CampaignMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CampaignDto> getAllCampaignsByUser(Long userId) {
        return campaignRepository.findAllByUserId(userId).stream().map(CampaignMapper::toDto).collect(Collectors.toList());
    }
}
