package com.Jasmineconnect.DonationSite.Service;

import com.Jasmineconnect.DonationSite.dto.DonationDto;

//Implement methods to create, retrieve, update, and delete donations. After creating a donation, trigger the email sending process.
public interface DonationService {

    // Method to create a new donation and trigger email sending
    DonationDto createDonation(DonationDto donationDto);

    // Method to retrieve a donation by its ID
    DonationDto getDonationById(Long donationId);

    // Method to update an existing donation
    DonationDto updateDonation(Long donationId, DonationDto donationDto);

    // Method to delete a donation by its ID
    void deleteDonation(Long donationId);
}

