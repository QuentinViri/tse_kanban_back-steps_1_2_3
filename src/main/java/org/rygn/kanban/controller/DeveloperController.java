package org.rygn.kanban.controller;

import org.rygn.kanban.dao.DeveloperRepository;
import org.rygn.kanban.domain.Developer;
import org.rygn.kanban.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("developer-rest")
public class DeveloperController {

    private DeveloperRepository developerRepository;

    @Autowired
    private DeveloperService developerService;

//    @GetMapping(value = "/{id}",produces = "application/json")
//    public Optional<Developer> getDeveloper(@PathVariable Long id){
//        return findDeveloperById(id);
//    }
    @GetMapping(value = "/developers",produces = "application/json")
    public List<Developer> getAllDevelopers(){
        return developerService.findAllDevelopers();
    }

    private Optional<Developer> findDeveloperById(Long id){
        return developerRepository.findById(id);
    }
}
