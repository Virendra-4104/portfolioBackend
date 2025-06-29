package com.example.portfolioBackend.service;

import com.example.portfolioBackend.entity.AdminUser;
import com.example.portfolioBackend.repository.AdminUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {

    private final AdminUserRepository adminUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public AdminUserService(AdminUserRepository adminUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.adminUserRepository = adminUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public AdminUser register(AdminUser adminUser){
        if (adminUserRepository.count() > 0 ){
            throw new IllegalStateException("Admin already exists");
        }
        adminUser.setPassword(bCryptPasswordEncoder.encode(adminUser.getPassword()));
        return adminUserRepository.save(adminUser);
    }


}
