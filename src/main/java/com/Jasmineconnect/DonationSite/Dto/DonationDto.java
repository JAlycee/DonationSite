package com.Jasmineconnect.DonationSite.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@Transactional
public class DonationDto {
    private Long id;

    @NotNull(message = "Amount cannot be null")
    @Min(value = 0, message = "Amount must be at least 0")
    private Double amount;

    @NotNull(message = "Message cannot be null")
    @Size(min = 5, max = 200, message = "Message must be between 5 and 200 characters")
    private String message;

    private Long campaignId;  // Only the ID, to avoid circular references

    @Getter
    @Setter
    private CampaignDto campaignDto; // CampaignDto object to hold campaign details

    // Setters and getters for userId and campaignDto
    @Setter
    private Long userId; // Only the ID, to avoid circular references

    @Getter
    @Setter
    private UserDto userDto; // UserDto object to hold user details

}
