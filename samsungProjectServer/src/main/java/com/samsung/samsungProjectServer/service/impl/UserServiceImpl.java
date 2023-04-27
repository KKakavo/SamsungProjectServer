package com.samsung.samsungProjectServer.service.impl;

import com.samsung.samsungProjectServer.domain.User;
import com.samsung.samsungProjectServer.exception.UserAlreadyExistsException;
import com.samsung.samsungProjectServer.exception.UserNotFoundException;
import com.samsung.samsungProjectServer.repository.UserRepository;
import com.samsung.samsungProjectServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User save(User user) {

        if(userRepository.findByEmail(user.getEmail()).isPresent())
            throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists.");

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);

    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {

        return userRepository.findByEmail(email).orElseThrow(
                () -> new UserNotFoundException("User with email " + email + " is not exists."));

    }

    @Override
    public User findUserById(long id) {

        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " is not exists"));

    }


}
