package com.Jasmineconnect.DonationSite.Repository;

import com.Jasmineconnect.DonationSite.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

