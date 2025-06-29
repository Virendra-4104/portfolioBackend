package com.example.portfolioBackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AdminUser {

    @Id
    private Long id = 1L;
    private String username;
    private String password;
}
