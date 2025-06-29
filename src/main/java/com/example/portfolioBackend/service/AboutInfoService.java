package com.example.portfolioBackend.service;

import com.example.portfolioBackend.entity.AboutInfo;
import com.example.portfolioBackend.repository.AboutInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AboutInfoService {

    private final AboutInfoRepository aboutInfoRepository;

    public AboutInfoService(AboutInfoRepository aboutInfoRepository){
        this.aboutInfoRepository= aboutInfoRepository;
    }

    public AboutInfo saveOrUpdateAboutInfo(AboutInfo aboutInfo) {
        Optional<AboutInfo> existing = aboutInfoRepository.findById(1L);

        if (existing.isPresent()) {
            AboutInfo existingInfo = existing.get();
            existingInfo.setFullName(aboutInfo.getFullName());
            existingInfo.setBio(aboutInfo.getBio());
            existingInfo.setEmail(aboutInfo.getEmail());
            existingInfo.setLocation(aboutInfo.getLocation());
            return aboutInfoRepository.save(existingInfo);
        } else {
            aboutInfo.setId(1L); // Enforce fixed ID
            return aboutInfoRepository.save(aboutInfo);
        }
    }

    public Optional<AboutInfo> getAboutInfo() {
        return aboutInfoRepository.findById(1L);
    }
}
