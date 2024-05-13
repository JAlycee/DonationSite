package com.Jasmineconnect.DonationSite.Controllers;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping
    public ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto campaignDto) {
        CampaignDto createdCampaign = campaignService.createCampaign(campaignDto);
        return new ResponseEntity<>(createdCampaign, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampaignDto> updateCampaign(@PathVariable Long id, @RequestBody CampaignDto updatedCampaign) {
        CampaignDto updated = campaignService.updateCampaign(id, updatedCampaign);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
        campaignService.deleteCampaign(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignDto> getCampaignById(@PathVariable Long id) {
        CampaignDto campaign = campaignService.getCampaignById(id);
        return ResponseEntity.ok(campaign);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CampaignDto>> searchCampaignsByName(@RequestParam String name) {
        List<CampaignDto> campaigns = campaignService.searchCampaignsByName(name);
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CampaignDto>> getAllCampaignsByUser(@PathVariable Long userId) {
        List<CampaignDto> campaigns = campaignService.getAllCampaignsByUser(userId);
        return ResponseEntity.ok(campaigns);
    }
}

