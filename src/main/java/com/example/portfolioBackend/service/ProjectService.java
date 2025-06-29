package com.example.portfolioBackend.service;

import com.example.portfolioBackend.entity.Project;
import com.example.portfolioBackend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {


     private ProjectRepository projectRepository;

     public ProjectService(ProjectRepository projectRepository){
         this.projectRepository = projectRepository;
     }

    // Gat all project
    public List<Project> getAllProject(){
        return projectRepository.findAll();
    }

    // Save project
    public Project saveProject(Project project){
        return projectRepository.save(project);
    }

    // Delete project by id
    public void deleteProjectById(Integer id){
        projectRepository.deleteById(id);
    }


    public Optional<Project> getProjectById(Integer id) {
       return projectRepository.findById(id);
    }
}
