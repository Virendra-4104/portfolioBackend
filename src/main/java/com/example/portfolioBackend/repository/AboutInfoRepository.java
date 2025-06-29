package com.example.portfolioBackend.repository;

import com.example.portfolioBackend.entity.AboutInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutInfoRepository extends JpaRepository<AboutInfo,Long> {
}
