package com.github.aqueleschulz.pandora_vault.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.aqueleschulz.pandora_vault.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByDocument(String document);
    Optional<User> findByEmail(String email);
}
