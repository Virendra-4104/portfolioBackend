package com.example.portfolioBackend.controller;

import com.example.portfolioBackend.entity.Project;
import com.example.portfolioBackend.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }


    @GetMapping("/get")
    public  ResponseEntity<?> getAllProject(){
         List<Project> projectsList = projectService.getAllProject();
         if (projectsList != null && !projectsList.isEmpty()){
             return new ResponseEntity<>(projectsList,HttpStatus.OK);
         }{
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveProject(@RequestBody Project project){
        try{
        projectService.saveProject(project);
        return new ResponseEntity<>(project,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update/id/{myId}")
    public ResponseEntity<?> updateProject(@PathVariable Integer myId, @RequestBody Project updatedProject){
        Project oldProject = projectService.getProjectById(myId).orElse(null);
        if (oldProject != null){
            oldProject.setTitle(updatedProject.getTitle() != null && !updatedProject.getTitle().equals("")? updatedProject.getTitle(): oldProject.getTitle());
            oldProject.setDescription(updatedProject.getDescription() != null && !updatedProject.getDescription().equals("")? updatedProject.getDescription(): oldProject.getDescription());
            oldProject.setLink(updatedProject.getLink() != null && !updatedProject.getLink().equals("")? updatedProject.getLink() : oldProject.getLink());
        projectService.saveProject(oldProject);
        return new ResponseEntity<>(oldProject,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<?> deleteProjectById(@PathVariable Integer id) {
        try {
            projectService.deleteProjectById(id);
            return new ResponseEntity<>("Project deleted successfully with id: " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Project not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }


}
