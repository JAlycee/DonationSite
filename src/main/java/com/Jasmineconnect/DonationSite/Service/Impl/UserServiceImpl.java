package com.Jasmineconnect.DonationSite.Service.Impl;

import com.Jasmineconnect.DonationSite.Entity.User;
import com.Jasmineconnect.DonationSite.Repository.UserRepository;
import com.Jasmineconnect.DonationSite.Service.UserService;
import com.Jasmineconnect.DonationSite.dto.UserDto;
import com.Jasmineconnect.DonationSite.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("User doesn't exist"));
        return UserMapper.mapToUserDto(user);
    }
    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("User doesn't exist"));

        // Update user properties with data from userDto
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        // Save the updated user to the repository
        User updatedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUser);
    }
    @Override
    public void deleteUser(Long userId) {
        // Check if the user exists
        if (userRepository.existsById(userId)) {
            // Delete the user by ID
            userRepository.deleteById(userId);
        } else {
            // If the user doesn't exist, throw an exception or handle it as needed
            throw new RuntimeException("User doesn't exist");
        }
    }

    @Override
    public List<UserDto> getAllUsers(String username) {
        return null;
    }
}
