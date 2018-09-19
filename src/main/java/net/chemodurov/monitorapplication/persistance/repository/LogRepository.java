package net.chemodurov.monitorapplication.persistance.repository;

import net.chemodurov.monitorapplication.persistance.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogRepository implements MyRepository<Log>{
    private final MongoTemplate template;

    @Autowired
    public LogRepository(MongoTemplate template) {
        this.template = template;
    }


    @Override
    public List<Log> findAllByCriteria(Criteria criteria) {
        Query query = new Query();
        query.addCriteria(criteria);
        return template.find(query, Log.class);
    }

    @Override
    public void save(Log entity) {
        template.save(entity);
    }

    public List<Log> findAll() {
        return template.findAll(Log.class);
    }
}
