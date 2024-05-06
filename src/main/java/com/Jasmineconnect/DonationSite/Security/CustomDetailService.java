package com.Jasmineconnect.DonationSite.Security;


import com.Jasmineconnect.DonationSite.Service.UserService;
import com.Jasmineconnect.DonationSite.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private final UserService userService;

    CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Assuming userService.getAllUsers(username) returns a list of UserDto
        UserDto userDto = (UserDto) userService.getAllUsers(username).get(0);
        return new UserPrincipal(
                userDto.getId(),
                userDto.getUsername(),
                Collections.singletonList(new SimpleGrantedAuthority(userDto.getRole())),
                userDto.getPassword()
        );
    }

    public UserDetails loadUserById(Long userId) {
        return null;
    }
}