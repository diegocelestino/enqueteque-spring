package com.enqueteque.services.impl;

import com.enqueteque.repositories.UserRepository;
import com.enqueteque.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
