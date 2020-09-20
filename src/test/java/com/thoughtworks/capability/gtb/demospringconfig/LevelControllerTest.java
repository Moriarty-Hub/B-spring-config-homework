package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class LevelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LevelController levelController;

    @Test
    public void should_return_basic_when_level_number_is_zero() throws Exception {
        ReflectionTestUtils.setField(levelController, "levelNumber", 0);
        mockMvc.perform(get("/level"))
                .andExpect(jsonPath("$", is("basic")));
    }

    @Test
    public void should_return_advanced_when_level_number_is_two() throws Exception {
        ReflectionTestUtils.setField(levelController, "levelNumber", 2);
        mockMvc.perform(get("/level"))
                .andExpect(jsonPath("$", is("advanced")));
    }
}
