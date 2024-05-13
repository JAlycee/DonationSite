package com.Jasmineconnect.DonationSite.Mappers;

import com.Jasmineconnect.DonationSite.Dto.UserDto;
import com.Jasmineconnect.DonationSite.Entity.User;
public class UserMapper {
    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User userDtoToUser(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        return user;
    }
}
