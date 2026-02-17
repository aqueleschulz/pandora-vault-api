package com.github.aqueleschulz.pandora_vault.domain;

import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Table(name = "users")
@Data
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

    private BigDecimal balance;
    
    @Enumerated(EnumType.STRING)
    private UserType userType;
}