package com.Jasmineconnect.DonationSite.Controllers;

import com.Jasmineconnect.DonationSite.Dto.DonationDto;
import com.Jasmineconnect.DonationSite.Entity.Donation;
import com.Jasmineconnect.DonationSite.Repository.DonationRepository;
import com.Jasmineconnect.DonationSite.Service.DonationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/donations")
public class DonationController {

    private final DonationService donationService;

    @Autowired
    private final DonationRepository donationRepository;

    @Autowired
    public DonationController(DonationService donationService, DonationRepository donationRepository) {
        this.donationService = donationService;
        this.donationRepository = donationRepository;
    }


    @PostMapping("/donations")
    public ResponseEntity<List<DonationDto>> createDonation(@Valid @RequestBody DonationDto donationDto) {

        List<Donation> allDonations = donationRepository.findAll(); // Retrieve all donations from the repository
        List<DonationDto> donationDtos = new ArrayList<>();
        for (Donation donation : allDonations) {
            donationDtos.add(new DonationDto()); // Convert entity to DTO
        }
        return ResponseEntity.ok(donationDtos);
    }


    @GetMapping("/{donationId}")
    public ResponseEntity<DonationDto> getDonationById(@PathVariable Long donationId) {
        Optional<DonationDto> donationDtoOptional = donationService.getDonationById(donationId);
        return donationDtoOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{donationId}")
    public ResponseEntity<DonationDto> updateDonation(@PathVariable Long donationId, @Valid @RequestBody DonationDto updatedDonationDto) {
        Optional<DonationDto> updatedDonation = donationService.updateDonation(donationId, updatedDonationDto);
        if (updatedDonation.isPresent()) {
            return (ResponseEntity<DonationDto>) ResponseEntity.ok();
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