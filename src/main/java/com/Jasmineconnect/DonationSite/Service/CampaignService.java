package com.Jasmineconnect.DonationSite.Service;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;

import java.util.List;
public interface CampaignService {
    CampaignDto createCampaign(CampaignDto campaign);
    CampaignDto updateCampaign(Long id, CampaignDto updatedCampaign);
    void deleteCampaign(Long id);
    CampaignDto getCampaignById(Long id);
    List<CampaignDto> searchCampaignsByName(String name);
    List<CampaignDto> getAllCampaignsByUser(Long id);
}
