package com.Jasmineconnect.DonationSite.Controllers;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/donations")
public class DonationController {

    private final DonationService donationService;

    @Autowired
    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping
    public ResponseEntity<DonationDto> createDonation(@RequestBody DonationDto donationDto) {
        DonationDto createdDonation = donationService.createDonation(donationDto);
        return ResponseEntity.ok(createdDonation);
    }

    @GetMapping("/{donationId}")
    public ResponseEntity<DonationDto> getDonationById(@PathVariable Long donationId) {
        Optional<DonationDto> donationDtoOptional = donationService.getDonationById(donationId);
        return donationDtoOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{donationId}")
    public ResponseEntity<Optional<DonationDto>> updateDonation(@PathVariable Long donationId, @RequestBody DonationDto updatedDonationDto) {
        Optional<DonationDto> updatedDonation = donationService.updateDonation(donationId, updatedDonationDto);
        if (updatedDonation.isPresent()) {
            return ResponseEntity.ok(updatedDonation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{donationId}")
    public ResponseEntity<Void> deleteDonation(@PathVariable Long donationId) {
        boolean deleted = donationService.deleteDonation(donationId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<DonationDto>> getAllDonations() {
        List<DonationDto> donations = donationService.getAllDonations();
        return ResponseEntity.ok(donations);
    }
}