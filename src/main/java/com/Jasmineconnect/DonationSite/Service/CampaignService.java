package com.Jasmineconnect.DonationSite.Service;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;

import java.util.List;
public interface CampaignService {
    CampaignDto createCampaign(CampaignDto campaignDto);
    CampaignDto updateCampaign(Long id, CampaignDto campaignDto);
    void deleteCampaign(Long id);
    CampaignDto getCampaignById(Long id);
    List<CampaignDto> getAllCampaigns();
    List<CampaignDto> searchCampaignsByName(String name);
}