package com.example.portfolioBackend.controller;

import com.example.portfolioBackend.entity.Skill;
import com.example.portfolioBackend.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {
    private final SkillService skillService;
    
    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllSkill(){
        List<Skill> allSkill = skillService.getAllSkill();
        if (!allSkill.isEmpty()){
            return new ResponseEntity<>(allSkill, HttpStatus.OK);
        }
        return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> saveSkill(@RequestBody Skill skill){
        try{
            Skill skill1 = skillService.saveSkill(skill);
            return new ResponseEntity<>(skill1,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("There is problem while creating",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable Long id, @RequestBody Skill newSkill){
        Skill oldSkill = skillService.getSkillById(id).orElse(null);
        if (oldSkill != null){
            oldSkill.setSkillName(newSkill.getSkillName() != null && !newSkill.getSkillName().equals("")?newSkill.getSkillName(): oldSkill.getSkillName());
            oldSkill.setSkillLevel(newSkill.getSkillLevel() != null && !newSkill.getSkillLevel().equals("")?newSkill.getSkillLevel(): oldSkill.getSkillName());
            Skill skill = skillService.saveSkill(oldSkill);
            return new ResponseEntity<>(skill,HttpStatus.OK);
        }
        return new ResponseEntity<>("Something Wrong",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteSkillById(@PathVariable Long id){
        try{
            skillService.deleteSkillById(id);
            return new ResponseEntity<>("Skill deleted! ",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Skill not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
