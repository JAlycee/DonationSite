package com.Jasmineconnect.DonationSite.Service;

import com.Jasmineconnect.DonationSite.dto.CampaignDto;

public interface CampaignService {

    CampaignDto createCampaign(CampaignDto campaignDto);

    CampaignDto getCampaignById(Long id);

    CampaignDto updateCampaign(Long id, CampaignDto campaignDto);

    void deleteCampaign(Long id);

    String getCampaignNameById(Long campaignId);
    }



