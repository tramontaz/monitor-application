package net.chemodurov.monitorapplication.persistance.repository;

import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

public interface MyRepository<T> {
    List<T> findAllByCriteria(Criteria criteria);
    void save(T entity);
}
