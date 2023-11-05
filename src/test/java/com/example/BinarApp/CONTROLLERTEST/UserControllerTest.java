package com.example.BinarApp.CONTROLLERTEST;

import com.example.BinarApp.MODEL.RESPONSE.UserRegisterResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {


        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @BeforeEach
        public void setUp() {
            // Perform any setup if needed before each test
        }

        @Test
        public void testRegisterSuccess() throws Exception {

            UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
            userRegisterResponse.setEmail("andika@hmail.com");
            userRegisterResponse.setUserName("andika");
            userRegisterResponse.setPassword("andika123");


            String requestJson = objectMapper.writeValueAsString(userRegisterResponse);


            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/register")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestJson))
                    .andReturn();


            int status = result.getResponse().getStatus();
            String content = result.getResponse().getContentAsString();

            assert(status == HttpStatus.OK.value());

            assert(content.equals("Registration successful"));
        }

}
