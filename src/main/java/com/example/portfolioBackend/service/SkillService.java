package com.example.portfolioBackend.service;

import com.example.portfolioBackend.entity.Skill;
import com.example.portfolioBackend.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAllSkill(){
        return skillRepository.findAll();
    }

    public Skill saveSkill(Skill skill){
        return skillRepository.save(skill);
    }

    public Optional<Skill> getSkillById(Long id){
        return skillRepository.findById(id);
    }

    public void deleteSkillById(Long id){
        skillRepository.deleteById(id);
    }
}
