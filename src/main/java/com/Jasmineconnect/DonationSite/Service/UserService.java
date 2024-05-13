package com.Jasmineconnect.DonationSite.Service;

import com.Jasmineconnect.DonationSite.Dto.UserDto;

import java.util.Optional;
public interface UserService {
    Optional<UserDto> getUserById(Long id);
    Optional<UserDto> getUserByUsername(String username); // Return Optional
}
