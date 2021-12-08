package org.rygn.kanban.controller;

import org.rygn.kanban.dao.TaskRepository;
import org.rygn.kanban.domain.Task;
import org.rygn.kanban.domain.TaskStatus;
import org.rygn.kanban.domain.TaskType;
import org.rygn.kanban.service.TaskService;
import org.rygn.kanban.utils.Constants;
import org.rygn.kanban.utils.TaskMoveAction;
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

    @GetMapping("/task_types")
    public Collection<TaskType> getAllTaskTypes(){
        return taskService.findAllTaskTypes();
    }

    @GetMapping("/task_status")
    Collection<TaskStatus> getAllTaskStatus() {
        return taskService.findAllTaskStatus();
    }

    @PostMapping("/tasks")
    public Task createNewTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @PatchMapping("/tasks/{id}")
    public Task moveTask(TaskMoveAction taskMoveAction, @PathVariable Long id){
        Task taskMoved = taskService.findTask(id);
        if (Constants.MOVE_LEFT_ACTION == taskMoveAction.getAction()){
            taskMoved = taskService.moveLeftTask(taskMoved);
        }
        else if (Constants.MOVE_RIGHT_ACTION == taskMoveAction.getAction()){
            taskMoved = taskService.moveRightTask(taskMoved);
        }
        else{
            taskMoved = taskMoved;
        }
        return taskMoved;
    }
}
