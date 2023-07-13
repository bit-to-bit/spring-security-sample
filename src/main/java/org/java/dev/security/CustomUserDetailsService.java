package org.java.dev.security;

import lombok.RequiredArgsConstructor;
import org.java.dev.dto.UserDto;
import org.java.dev.entity.User;
import org.java.dev.mapper.UserMapper;
import org.java.dev.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return userMapper.mapEntityToDto(user);
    }

    public void createUser(UserDetails user) {
        User userEntity = userMapper.mapDtoToEntity((UserDto) user);
        encodePassword(userEntity);
        userRepository.save(userEntity);
    }

    public void updateUser(UserDetails user) {
        User userEntity = userMapper.mapDtoToEntity((UserDto) user);
        encodePassword(userEntity);
        userRepository.save(userEntity);
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    private void encodePassword(User userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
    }
}
