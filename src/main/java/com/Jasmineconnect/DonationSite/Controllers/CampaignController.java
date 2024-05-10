package com.Jasmineconnect.DonationSite.Controllers;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Service.CampaignService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }


    @PostMapping
    public ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto campaignDto) {
        CampaignDto createdCampaign = campaignService.createCampaign(campaignDto);
        return ResponseEntity.ok(createdCampaign);
    }

    @GetMapping("/{campaignId}")
    public ResponseEntity<CampaignDto> getCampaignById(@PathVariable Long campaignId) {
        Optional<CampaignDto> campaignDtoOptional = campaignService.getCampaignById(campaignId);
        return campaignDtoOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{campaignId}")
    public ResponseEntity<CampaignDto> updateCampaign(@PathVariable Long campaignId, @RequestBody CampaignDto updatedCampaignDto) throws ChangeSetPersister.NotFoundException {
        Optional<CampaignDto> updatedCampaignOptional = campaignService.updateCampaign(campaignId, updatedCampaignDto);
        return updatedCampaignOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{campaignId}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long campaignId) {
        boolean deleted = campaignService.deleteCampaign(campaignId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CampaignDto>> getAllCampaigns() {
        List<CampaignDto> campaigns = campaignService.findAllCampaigns();
        return ResponseEntity.ok(campaigns);
    }
}