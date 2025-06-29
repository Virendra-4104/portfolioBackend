package com.example.portfolioBackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AboutInfo {
    @Id
    private Long id = 1L;
    private String fullName;
    @Column(length = 2000)
    private String bio;
    private String location;
    private String email;
}
