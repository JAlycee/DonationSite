package com.Jasmineconnect.DonationSite.mapper;

import com.Jasmineconnect.DonationSite.Entity.User;
import com.Jasmineconnect.DonationSite.dto.UserDto;

public class UserMapper {

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword()
        );
    }

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}

