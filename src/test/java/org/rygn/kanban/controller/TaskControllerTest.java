package org.rygn.kanban.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.rygn.kanban.domain.Developer;
import org.rygn.kanban.domain.Task;
import org.rygn.kanban.service.DeveloperService;
import org.rygn.kanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private TaskService taskService;

    @Test
    void getAllTasks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tasks").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void getAllTaskTypes() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/task_types").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAllTaskStatus() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/task_status").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createNewTask() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tasks").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void moveTask() throws Exception{

//        mockMvc.perform(MockMvcRequestBuilders.patch("/tasks/").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
    }
}