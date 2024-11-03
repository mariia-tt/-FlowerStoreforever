package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet
.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request
.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result
.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class FlowerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddFlower() throws Exception {
        String flowerJson 
 = "{\"name\": \"Lily\",\"color\": \"Pink\",\"price\": 1.75,\"available\": true}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/flower")
                .contentType(MediaType.APPLICATION_JSON)
                .content(flowerJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
