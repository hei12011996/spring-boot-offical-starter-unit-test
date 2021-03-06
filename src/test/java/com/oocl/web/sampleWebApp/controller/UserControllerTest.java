package com.oocl.web.sampleWebApp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String DUMMY_USER_JSON_STRING = "{\"username\": \"DUMMY_NAME\"}";

    @Test
    public void should_return_status_code_201_Created_and_have_location() throws Exception {
        this.mockMvc.perform(
                    post("/users")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(DUMMY_USER_JSON_STRING)
                )
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/users/0"));
    }
}
