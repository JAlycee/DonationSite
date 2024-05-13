package com.Jasmineconnect.DonationSite.Controllers;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    // Create a new donation
    @PostMapping
    public ResponseEntity<DonationDto> makeDonation(@RequestBody DonationDto donationDto) {
        DonationDto newDonation = donationService.makeDonation(donationDto);
        return new ResponseEntity<>(newDonation, HttpStatus.CREATED);
    }

    // Get all donations for a specific campaign
    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<DonationDto>> getDonationsByCampaign(@PathVariable Long campaignId) {
        List<DonationDto> donations = donationService.getDonationsByCampaign(campaignId);
        return ResponseEntity.ok(donations);
    }
    @GetMapping
    public ResponseEntity<List<DonationDto>> getAllDonations() {
        List<DonationDto> donations = donationService.getAllDonations();
        return ResponseEntity.ok(donations);
    }

}