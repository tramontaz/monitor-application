package net.chemodurov.monitorapplication.controller;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class LogControllerTest {
    //todo: mocking service
    private MockMvc mockMvc;

    @Test
    public void getAllByParameters() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/getAll?instance=monitor-application")).andExpect(status().isOk());
        //todo: fix tests
    }

    @Test
    public void addLog() {
        //todo: make tests
    }
}