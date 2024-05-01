package com.Jasmineconnect.DonationSite.Service.Impl;
// UserServiceImpl Class
import com.Jasmineconnect.DonationSite.Entity.User;
import com.Jasmineconnect.DonationSite.Repository.UserRepository;
import com.Jasmineconnect.DonationSite.Service.UserService;
import com.Jasmineconnect.DonationSite.dto.UserDto;
import com.Jasmineconnect.DonationSite.mapper.UserMapper;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
