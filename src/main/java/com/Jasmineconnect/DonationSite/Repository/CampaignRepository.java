package com.Jasmineconnect.DonationSite.Repository;

import com.Jasmineconnect.DonationSite.Entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    <GoalAmount> List<Campaign> findByGoalAmount(GoalAmount goalAmount);
}
