package com.Jasmineconnect.DonationSite.Service.Impl;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
import com.Jasmineconnect.DonationSite.Repository.CampaignRepository;
import com.Jasmineconnect.DonationSite.Service.CampaignService;
import com.Jasmineconnect.DonationSite.dto.CampaignDto;
import com.Jasmineconnect.DonationSite.mapper.CampaignMapper;
import org.springframework.stereotype.Service;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final CampaignMapper campaignMapper;

    public CampaignServiceImpl(CampaignRepository campaignRepository, CampaignMapper campaignMapper) {
        this.campaignRepository = campaignRepository;
        this.campaignMapper = campaignMapper;
    }

    @Override
    public CampaignDto createCampaign(CampaignDto campaignDto) {
        Campaign campaign = campaignMapper.mapToCampaign(campaignDto);
        Campaign savedCampaign = campaignRepository.save(campaign);
        return campaignMapper.mapToCampaignDto(savedCampaign);
    }

    @Override
    public CampaignDto getCampaignById(Long id) {
        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
        return campaignMapper.mapToCampaignDto(campaign);
    }

    @Override
    public CampaignDto updateCampaign(Long id, CampaignDto campaignDto) {
        Campaign existingCampaign = campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
        existingCampaign.setName(campaignDto.getName());
        existingCampaign.setDescription(campaignDto.getDescription());

        Campaign updatedCampaign = campaignRepository.save(existingCampaign);
        return campaignMapper.mapToCampaignDto(updatedCampaign);
    }

    @Override
    public void deleteCampaign(Long id) {
        if (campaignRepository.existsById(id)) {
            campaignRepository.deleteById(id);
        } else {
            throw new RuntimeException("Campaign not found");
        }
    }

    @Override
    public String getCampaignNameById(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
        return campaign.getName();
    }
}
