package com.Jasmineconnect.DonationSite.Dto;

import com.Jasmineconnect.DonationSite.Entity.Campaign;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Data
@Transactional
public class  CampaignDto {
    private Long id;

    @NotBlank(message = "Campaign name is required")  // NotBlank automatically implies NotNull
    @Size(max = 255, message = "Campaign name must not exceed 255 characters")
    private String name;

    @NotBlank(message = "Campaign description is required") // NotBlank implies non-null and non-empty
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    @NotNull(message = "Goal amount is required")
    @DecimalMin(value = "0.01", message = "Goal amount must be at least 0.01")
    private Double goalAmount;

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date must be today or in the future")
    private Date startDate;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be after the start date")
    private Date endDate;

    public CampaignDto(Campaign campaign) {
    }

    public CampaignDto() {
    }

}