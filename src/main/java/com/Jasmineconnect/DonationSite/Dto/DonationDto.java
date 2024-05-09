package com.Jasmineconnect.DonationSite.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@Transactional
public class DonationDto {
    private Long id;
    private Double amount;
    private String message;
    private Long campaignId;  // Only the ID, to avoid circular references
}