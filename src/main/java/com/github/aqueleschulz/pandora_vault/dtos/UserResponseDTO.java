package com.github.aqueleschulz.pandora_vault.dtos;

import com.github.aqueleschulz.pandora_vault.domain.UserType;
import java.math.BigDecimal;

public record UserResponseDTO (
    Long id,
    String firstName,
    String lastName,
    String document,
    BigDecimal balance,
    String email,
    UserType userType
){
}
