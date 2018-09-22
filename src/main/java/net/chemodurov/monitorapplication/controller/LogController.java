package net.chemodurov.monitorapplication.controller;

import lombok.extern.slf4j.Slf4j;
import net.chemodurov.monitorapplication.persistance.model.Log;
import net.chemodurov.monitorapplication.persistance.model.SearchCriteria;
import net.chemodurov.monitorapplication.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class LogController {
    private static final String ENTER_POINT_GET_ALL_BY_PARAMETERS = "/getAll";
    private static final String ENTER_POINT_ADD_LOG = "/addLog";
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping(ENTER_POINT_GET_ALL_BY_PARAMETERS)
    public ResponseEntity getAllByParameters(@RequestParam("instance") String instance,
                                             @RequestParam(value = "message", required = false) String partOfMessage,
                                             @RequestParam(value = "dateFrom", required = false) Date from,
                                             @RequestParam(value = "dateTo", required = false) Date to) {
        SearchCriteria sc = SearchCriteria.builder()
                .instance(instance)
                .partOfMessage(partOfMessage)
                .startDate(from)
                .endDate(to).build();
        List<Log> result = logService.getAllByParameters(sc);
        if (result != null && result.size() > 0) {
            log.info("Requested all logs with parameters: {}", sc.toLog());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.info("Couldn't found logs with parameters: {}", sc.toLog());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(ENTER_POINT_ADD_LOG)
    public ResponseEntity addLog(@RequestBody Log entity) {
        try {
            logService.addLog(entity);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't save log: {}", entity);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
