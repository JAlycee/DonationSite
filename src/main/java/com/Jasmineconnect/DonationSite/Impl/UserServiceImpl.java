package com.Jasmineconnect.DonationSite.Impl;

import com.Jasmineconnect.DonationSite.Dto.UserDto;
import com.Jasmineconnect.DonationSite.Mappers.UserMapper;
import com.Jasmineconnect.DonationSite.Repository.UserRepository;
import com.Jasmineconnect.DonationSite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto> getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto> getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserMapper::toDto);
    }
}