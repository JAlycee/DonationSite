package com.Jasmineconnect.DonationSite.Controllers;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public ResponseEntity<DonationDto> makeDonation(@RequestBody DonationDto donation) {
        DonationDto madeDonation = donationService.makeDonation(donation);
        return ResponseEntity.ok(madeDonation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DonationDto>> getDonationsByUser(@PathVariable Long userId) {
        List<DonationDto> donations = donationService.getDonationsByUser(userId);
        return ResponseEntity.ok(donations);
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<DonationDto>> getDonationsByCampaign(@PathVariable Long campaignId) {
        List<DonationDto> donations = donationService.getDonationsByCampaign(campaignId);
        return ResponseEntity.ok(donations);
    }
}
