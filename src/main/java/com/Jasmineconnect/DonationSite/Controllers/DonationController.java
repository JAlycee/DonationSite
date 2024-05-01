package com.Jasmineconnect.DonationSite.Controllers;
// Define REST endpoints for handling donation-related requests. Map these endpoints to appropriate methods in the DonationService.
import com.Jasmineconnect.DonationSite.Service.DonationService;
import com.Jasmineconnect.DonationSite.dto.DonationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/donations")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping
    public ResponseEntity<DonationDto> createDonation(@RequestBody DonationDto donationDto) {
        DonationDto createdDonation = donationService.createDonation(donationDto);
        return new ResponseEntity<>(createdDonation, HttpStatus.CREATED);
    }

    @GetMapping("/{donationId}")
    public ResponseEntity<DonationDto> getDonationById(@PathVariable Long donationId) {
        DonationDto donationDto = donationService.getDonationById(donationId);
        return new ResponseEntity<>(donationDto, HttpStatus.OK);
    }

    @PutMapping("/{donationId}")
    public ResponseEntity<DonationDto> updateDonation(@PathVariable Long donationId, @RequestBody DonationDto donationDto) {
        DonationDto updatedDonation = donationService.updateDonation(donationId, donationDto);
        return new ResponseEntity<>(updatedDonation, HttpStatus.OK);
    }

    @DeleteMapping("/{donationId}")
    public ResponseEntity<Void> deleteDonation(@PathVariable Long donationId) {
        donationService.deleteDonation(donationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


