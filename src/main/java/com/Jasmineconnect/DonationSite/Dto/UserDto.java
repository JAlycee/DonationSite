package com.Jasmineconnect.DonationSite.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@Transactional
public class UserDto {
    private Long id;
    private String username;
    private String email;

    public UserDto() {
    }
}
