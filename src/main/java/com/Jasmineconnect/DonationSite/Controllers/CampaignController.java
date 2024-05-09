package com.Jasmineconnect.DonationSite.Controllers;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/campaigns")
@CrossOrigin(origins = "http://localhost:3000")
public class CampaignController {

    private final CampaignService campaignService;

    @Autowired
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping
    public ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto campaignDto) {
        CampaignDto newCampaign = campaignService.createCampaign(campaignDto);
        return new ResponseEntity<>(newCampaign, HttpStatus.CREATED);
    }
//    @PostMapping
//    public ResponseEntity<CampaignDto> createCampaign(@RequestBody @Valid CampaignDto campaignDto) {
//        try {
//            CampaignDto createdCampaign = campaignService.createCampaign(campaignDto);
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdCampaign);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }

// Works
@GetMapping("/{id}")
public ResponseEntity<CampaignDto> getCampaignById(@PathVariable Long id) {
    return campaignService.getCampaignById(id)
            .map(ResponseEntity::ok)
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

    @PutMapping("/{id}")
    public ResponseEntity<CampaignDto> updateCampaign(@PathVariable Long id, @RequestBody CampaignDto campaignDto) {
        return campaignService.updateCampaign(id, campaignDto)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
        boolean isDeleted = campaignService.deleteCampaign(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<CampaignDto>> findByGoalAmount(@RequestParam Double goalAmount) {
        List<CampaignDto> campaigns = campaignService.findByGoalAmount(goalAmount);
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/search-name")
    public ResponseEntity<List<CampaignDto>> findByName(@RequestParam String name) {
        List<CampaignDto> campaigns = campaignService.findByName(name);
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping
    public ResponseEntity<List<CampaignDto>> getAllCampaigns() {
        List<CampaignDto> campaigns = campaignService.findAllCampaigns();
        return ResponseEntity.ok(campaigns);
    }
}