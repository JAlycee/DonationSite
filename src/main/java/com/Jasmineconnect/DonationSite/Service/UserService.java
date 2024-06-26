package com.Jasmineconnect.DonationSite.Service;

import com.Jasmineconnect.DonationSite.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    UserDto updateUser(Long userId, UserDto userDto);
    void deleteUser(Long userId);

    List<UserDto> getAllUsers(String username);
}