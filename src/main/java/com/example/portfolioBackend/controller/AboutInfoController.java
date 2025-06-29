package com.example.portfolioBackend.controller;

import com.example.portfolioBackend.entity.AboutInfo;
import com.example.portfolioBackend.service.AboutInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/about")
public class AboutInfoController {
    private final AboutInfoService aboutInfoService;

    public AboutInfoController(AboutInfoService aboutInfoService) {
        this.aboutInfoService = aboutInfoService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAboutInfo() {
        Optional<AboutInfo> aboutInfo = aboutInfoService.getAboutInfo();
        if (aboutInfo.isPresent()) {
            return new ResponseEntity<>(aboutInfo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("About info not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create-or-update")
    public ResponseEntity<?> createOrUpdateAboutInfo(@RequestBody AboutInfo aboutInfo) {
        try {
            AboutInfo saved = aboutInfoService.saveOrUpdateAboutInfo(aboutInfo);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save/update", HttpStatus.BAD_REQUEST);
        }
    }
}
