package com.github.aqueleschulz.pandora_vault.services;

import org.springframework.stereotype.Service;

import com.github.aqueleschulz.pandora_vault.repositories.UserRepository;
import com.github.aqueleschulz.pandora_vault.dtos.UserRequestDTO;
import com.github.aqueleschulz.pandora_vault.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(UserRequestDTO data)
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

        userRepository.findByDocument(data.document()).ifPresent(user -> {
            throw new IllegalArgumentException("Documento já cadastrado.");
        });

        userRepository.findByEmail(data.email()).ifPresent(user -> {
            throw new IllegalArgumentException("Email já cadastrado.");
        });

        return userRepository.save(newUser);
    }
}
