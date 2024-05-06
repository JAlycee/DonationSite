package com.Jasmineconnect.DonationSite.Security;

import com.Jasmineconnect.DonationSite.Entity.User;
import com.Jasmineconnect.DonationSite.Repository.UserRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtToPrincipal {

    @Autowired
    private UserRepository userRepository;

    public UserPrincipal convert(Claims claims) {
        String userIdString = claims.getSubject();
        if (userIdString == null) {
            throw new UsernameNotFoundException("User ID not found in JWT claims");
        }
        Long userId = Long.parseLong(userIdString);
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id: " + userId));
        return UserPrincipal.create(user);
    }
}
