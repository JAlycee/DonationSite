package com.Jasmineconnect.DonationSite.Controllers;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Service.DonationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<DonationDto> createDonation(@Valid @RequestBody DonationDto donationDto) {
        DonationDto createdDonation = donationService.createDonation(donationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDonation);
    }

    @GetMapping("/{donationId}")
    public ResponseEntity<DonationDto> getDonationById(@PathVariable Long donationId) {
        return donationService.getDonationById(donationId)
                .map(donation -> ResponseEntity.ok(donation))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{donationId}")
    public ResponseEntity<DonationDto> updateDonation(@PathVariable Long donationId, @Valid @RequestBody DonationDto donationDto) {
        return donationService.updateDonation(donationId, donationDto)
                .map(donation -> ResponseEntity.ok(donation))
                .orElse(ResponseEntity.notFound().build());
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