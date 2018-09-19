package net.chemodurov.monitorapplication.service;

import net.chemodurov.monitorapplication.persistance.model.Log;
import net.chemodurov.monitorapplication.persistance.model.SearchCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogServiceTest {
    @Autowired
    private LogService service;

    @Test
    public void getAllByParameters() {
        List<Log> logList = service.getAllByParameters(SearchCriteria.builder().instance("monitor-application").build());
        assertTrue(logList.size() > 0);
    }

    @Test
    public void addLog() {
        Log log = Log.builder()
                .instance("monitor-application")
                .datetime(new Date())
                .logLevel(2)
                .message("Calculated successful.")
                .build();
        service.addLog(log);
    }
}