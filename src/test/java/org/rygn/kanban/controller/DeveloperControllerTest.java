package org.rygn.kanban.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
class DeveloperControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllDevelopers() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/developers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}