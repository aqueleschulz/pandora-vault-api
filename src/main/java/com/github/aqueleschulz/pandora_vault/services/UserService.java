package com.github.aqueleschulz.pandora_vault.services;

import org.springframework.stereotype.Service;

import com.github.aqueleschulz.pandora_vault.repositories.UserRepository;
import com.github.aqueleschulz.pandora_vault.dtos.UserDTO;
import com.github.aqueleschulz.pandora_vault.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User createUser(UserDTO data)
    {
        User newUser = User.builder()
        .firstName(data.firstName())
        .lastName(data.lastName())
        .document(data.document())
        .balance(data.balance())
        .email(data.email())
        .password(data.password())
        .userType(data.userType())
        .build();

        return userRepository.save(newUser);
    }
}
