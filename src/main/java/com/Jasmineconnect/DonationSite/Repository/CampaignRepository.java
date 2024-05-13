package com.Jasmineconnect.DonationSite.Repository;

import com.Jasmineconnect.DonationSite.Entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findByNameContaining(String name);
    List<Campaign> findAllByUserId(Long userId);
}
