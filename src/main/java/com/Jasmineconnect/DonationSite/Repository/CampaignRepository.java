package com.Jasmineconnect.DonationSite.Repository;

import com.Jasmineconnect.DonationSite.Entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}