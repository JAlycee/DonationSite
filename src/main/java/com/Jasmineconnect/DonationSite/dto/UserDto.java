package com.Jasmineconnect.DonationSite.dto;

import com.Jasmineconnect.DonationSite.Service.Impl.UserServiceImpl;
import com.Jasmineconnect.DonationSite.Service.UserService;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;

    public String getRole() {
        return null;
    }

    private UserService userService;
    List<UserDto> users = userService.getAllUsers(username);
    UserDto userDto = users.get(0);
}
