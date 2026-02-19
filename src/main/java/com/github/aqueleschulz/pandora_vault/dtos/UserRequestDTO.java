package com.github.aqueleschulz.pandora_vault.dtos;

import com.github.aqueleschulz.pandora_vault.domain.UserType;
import java.math.BigDecimal;

public record UserRequestDTO (
    String firstName,
    String lastName,
    String document,
    BigDecimal balance,
    String email,
    String password,
    UserType userType
){
}
