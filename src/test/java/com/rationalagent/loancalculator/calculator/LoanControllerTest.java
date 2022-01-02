package com.rationalagent.loancalculator.calculator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenARunningApplication_whenSendingRequestWithValidPayload_thenReturns200() throws Exception {
        mockMvc.perform(post("/loans")).andExpect(status().isOk());

        mockMvc.perform(
                        put("/loans/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(Files.readString(Path.of("src", "test", "resources", "json", "valid-loan-spec.json"))))
                .andExpect(status().isOk());

        mockMvc.perform(
                        post("/loans/1/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(Files.readString(Path.of("src", "test", "resources", "json", "valid-request.json"))))
                .andExpect(status().isOk());
    }

    @Test
    @Disabled
    void givenARunningApplication_whenSendingRequestWithInvalidPayload_thenReturns400() throws Exception {
        mockMvc.perform(
                        post("/loans/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(Files.readString(Path.of("src", "test", "resources", "json", "invalid-request.json"))))
                .andExpect(status().isBadRequest());
    }
}
