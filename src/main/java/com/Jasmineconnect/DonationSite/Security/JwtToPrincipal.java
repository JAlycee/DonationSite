package com.Jasmineconnect.DonationSite.Security;

import com.Jasmineconnect.DonationSite.Entity.User;
import com.Jasmineconnect.DonationSite.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtToPrincipal {

    @Autowired
    private UserRepository userRepository;

    public UserPrincipal convert(Claims claims) {
        Long userId = Long.parseLong(claims.getSubject());
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id: " + userId));
        return UserPrincipal.create(user);
    }
}

