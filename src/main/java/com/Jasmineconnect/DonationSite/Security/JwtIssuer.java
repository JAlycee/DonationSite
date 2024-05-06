package com.Jasmineconnect.DonationSite.Security;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class JwtIssuer {

    @Autowired
    private JwtProperties jwtProperties;

    // Method to issue a JWT token
    public String issue(int userId, String email, List<String> roles) {
        return JWT.create()
                .withSubject(String.valueOf(userId)) // Set the subject (user ID)
                .withExpiresAt(Instant.now().plus(1, ChronoUnit.DAYS)) // Set expiration time
                .withClaim("e", email) // Add email claim
                .withClaim("a", roles) // Add roles claim
                .sign(Algorithm.HMAC256(jwtProperties.getSecretKey())); // Sign the token with the secret key
    }
}
