package com.Jasmineconnect.DonationSite.Service.Impl;

import com.Jasmineconnect.DonationSite.Entity.Donation;
import com.Jasmineconnect.DonationSite.Service.EmailService;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendDonationConfirmationEmail(Donation donation) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(donation.getUser().getEmail());
        mailMessage.setSubject("Donation Confirmation");
        mailMessage.setText("Thank you for your donation of $" + donation.getAmount() + " to the campaign '" + donation.getCampaign().getName() + "'.");

        try {
            javaMailSender.send(mailMessage);
        } catch (MailException e) {
            // Handle mail sending exception
            e.printStackTrace();
            // You may throw a custom exception or handle it differently based on your application's requirements
        }
    }
}

