package com.Jasmineconnect.DonationSite;

import com.Jasmineconnect.DonationSite.Controllers.CampaignController;
import com.Jasmineconnect.DonationSite.Service.CampaignService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DonationSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonationSiteApplication.class, args);
	}
	@Bean
	public CampaignController campaignController(CampaignService campaignService) {
		return new CampaignController(campaignService);
	}
}
