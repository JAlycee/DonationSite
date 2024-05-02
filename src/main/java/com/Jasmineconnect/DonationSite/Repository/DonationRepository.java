package com.Jasmineconnect.DonationSite.Repository;

import com.Jasmineconnect.DonationSite.Entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    Optional<Donation> findById(Long id);

    List<Donation> findAll();

    List<Donation> findByUserId(Long userId);

    List<Donation> findByCampaignId(Long campaignId);

    List<Donation> findByAmountGreaterThanEqual(BigDecimal amount);

    List<Donation> findByDonationDateBetween(LocalDate startDate, LocalDate endDate);

    List<Donation> findByUserIdAndCampaignId(Long userId, Long campaignId);
}
}
