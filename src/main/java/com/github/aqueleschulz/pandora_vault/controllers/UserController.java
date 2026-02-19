package com.github.aqueleschulz.pandora_vault.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.github.aqueleschulz.pandora_vault.dtos.UserRequestDTO;
import com.github.aqueleschulz.pandora_vault.dtos.UserResponseDTO;
import com.github.aqueleschulz.pandora_vault.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO data) {
        var user = userService.createUser(data);
        var response = new UserResponseDTO(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getDocument(),
            user.getBalance(),
            user.getEmail(),
            user.getUserType()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
}
