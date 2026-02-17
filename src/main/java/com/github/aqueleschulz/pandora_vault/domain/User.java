package com.github.aqueleschulz.pandora_vault.domain;

 import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor; 

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    
    private String lastName;

    @Column(unique = true)
    private String document;
    
    @Email
    @Column(unique = true)
    private String email;

    private String password;

    @Column(precision = 13, scale = 2) 
    private BigDecimal balance;
    
    @Enumerated(EnumType.STRING)
    private UserType userType;
}