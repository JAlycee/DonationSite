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

    @PostMapping("/campaign")
    public ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto campaignDto) {
        // Logic to create the campaign and save it to the database
        // Return the created campaign DTO along with a success status code
        CampaignDto createdCampaignDto = campaignService.createCampaign(campaignDto);
        return new ResponseEntity<>(createdCampaignDto, HttpStatus.CREATED);
    }

    // Update an existing campaign
    @PutMapping("/{id}")
    public ResponseEntity<CampaignDto> updateCampaign(@PathVariable Long id, @RequestBody CampaignDto campaignDto) {
        CampaignDto updatedCampaign = campaignService.updateCampaign(id, campaignDto);
        return ResponseEntity.ok(updatedCampaign);
    }

    // Delete a campaign
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
        campaignService.deleteCampaign(id);
        return ResponseEntity.noContent().build();
    }

    // Get a specific campaign by ID
    @GetMapping("/{id}")
    public ResponseEntity<CampaignDto> getCampaignById(@PathVariable Long id) {
        CampaignDto campaign = campaignService.getCampaignById(id);
        return ResponseEntity.ok(campaign);
    }

    // List all campaigns
    @GetMapping
    public List<CampaignDto> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    // Search campaigns by name
    @GetMapping("/search")
    public ResponseEntity<List<CampaignDto>> searchCampaignsByName(@RequestParam String name) {
        List<CampaignDto> campaigns = campaignService.searchCampaignsByName(name);
        return ResponseEntity.ok(campaigns);
    }
}
