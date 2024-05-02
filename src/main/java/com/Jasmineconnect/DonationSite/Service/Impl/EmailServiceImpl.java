package com.Jasmineconnect.DonationSite.Service.Impl;

import com.Jasmineconnect.DonationSite.Entity.Donation;
import com.Jasmineconnect.DonationSite.Service.CampaignService;
import com.Jasmineconnect.DonationSite.Service.EmailService;
import com.Jasmineconnect.DonationSite.Service.MailtrapService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final MailtrapService mailtrapService;
    private final CampaignService campaignService;

    public EmailServiceImpl(MailtrapService mailtrapService, CampaignService campaignService) {
        this.mailtrapService = mailtrapService;
        this.campaignService = campaignService;
    }

    @Override
    public void sendDonationConfirmationEmail(Donation donation) {
        String recipient = donation.getUser().getEmail();
        double amount = donation.getAmount();
        Long campaignId = donation.getCampaign().getId();
        String campaignName = campaignService.getCampaignNameById(campaignId); // Fetch campaign name

        String subject = "Donation Confirmation";
        String body = "Thank you for your donation of $" + amount + " to campaign " + campaignName + ".";

        // Send email using MailtrapService
        mailtrapService.sendEmail(recipient, subject, body);
    }
}

