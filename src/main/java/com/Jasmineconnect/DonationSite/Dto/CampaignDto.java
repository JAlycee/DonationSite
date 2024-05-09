package com.Jasmineconnect.DonationSite.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Getter
@Setter
@Transactional
public class  CampaignDto {
    private Long id;
    private String name;
    private String description;
    private Double goalAmount;
    private Date startDate;
    private Date endDate;
}