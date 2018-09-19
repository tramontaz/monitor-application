package net.chemodurov.monitorapplication.service;

import net.chemodurov.monitorapplication.persistance.model.Log;
import net.chemodurov.monitorapplication.persistance.model.SearchCriteria;
import net.chemodurov.monitorapplication.persistance.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<Log> getAllByParameters(SearchCriteria searchCriteria) {
        Criteria criteria = new Criteria();

        if (searchCriteria == null)
            return logRepository.findAll();

        if (searchCriteria.getInstance() != null) {
            criteria.and("instance").is(searchCriteria.getInstance());
        }
        if (searchCriteria.getPartOfMessage() != null) {
            criteria.and("message").regex(searchCriteria.getPartOfMessage());
        }
        if (searchCriteria.getStartDate() != null) {
            criteria.and("date").gte(searchCriteria.getStartDate());
        }
        if (searchCriteria.getEndDate() != null) {
            criteria.and("date").lte(searchCriteria.getEndDate());
        }

        return logRepository.findAllByCriteria(criteria);
    }

    public void addLog(Log log) {
        logRepository.save(log);
    }
}
