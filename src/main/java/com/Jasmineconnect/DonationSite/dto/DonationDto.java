package com.Jasmineconnect.DonationSite.dto;
import lombok.Data;

@Data
public class DonationDto {
    private Long id;
    private double amount;
    private Long userId;
    private Long campaignId;
    private String userEmail;
}
