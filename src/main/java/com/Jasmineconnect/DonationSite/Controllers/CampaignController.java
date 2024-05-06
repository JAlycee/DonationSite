package com.Jasmineconnect.DonationSite.Controllers;

import com.Jasmineconnect.DonationSite.Entity.Campaign;
import com.Jasmineconnect.DonationSite.Repository.CampaignRepository;
import com.Jasmineconnect.DonationSite.Service.CampaignService;
//import com.Jasmineconnect.DonationSite.dto.CampaignDto;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

        @Autowired
        private CampaignRepository campaignRepository;

        @GetMapping("/search")
        public List<Campaign> searchCampaignsByGoalType(@RequestParam GoalAmount goalType) {
            return campaignRepository.findByGoalType(goalType);
        }

//    @PostMapping
//    public ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto campaignDto) {
//        CampaignDto createdCampaign = campaignService.createCampaign(campaignDto);
//        return new ResponseEntity<>(createdCampaign, HttpStatus.CREATED);


//    @GetMapping("/{id}")
//    public ResponseEntity<CampaignDto> getCampaignById(@PathVariable Long id) {
//        CampaignDto campaignDto = campaignService.getCampaignById(id);
//        return ResponseEntity.ok(campaignDto);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CampaignDto> updateCampaign(@PathVariable Long id, @RequestBody CampaignDto campaignDto) {
//        CampaignDto updatedCampaign = campaignService.updateCampaign(id, campaignDto);
//        return ResponseEntity.ok(updatedCampaign);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
//        campaignService.deleteCampaign(id);
//        return ResponseEntity.noContent().build();
//    }
//}
