package com.Jasmineconnect.DonationSite.Service;

import com.Jasmineconnect.DonationSite.Entity.Donation;

public interface EmailService {
    void sendDonationConfirmationEmail(Donation donation);
}
