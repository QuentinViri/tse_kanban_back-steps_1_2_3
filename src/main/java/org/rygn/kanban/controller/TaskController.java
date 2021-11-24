package org.rygn.kanban.controller;

import org.rygn.kanban.dao.TaskRepository;
import org.rygn.kanban.domain.Task;
import org.rygn.kanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("task-rest")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping(value = "/tasks",produces = "application/json")
    public Collection<Task> getAllTasks(){
        return taskService.findAllTasks();
    }

    @PostMapping("/tasks")
    public Task createNewTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PatchMapping("/tasks/{id}")
    public Task moveTask(String direction, @RequestBody Task task){
        Task movedTask = switch(direction){
            case "left" -> taskService.moveLeftTask(task);
            case "right"-> taskService.moveRightTask(task);
            default -> task;
        };
        return movedTask;
    }
}
