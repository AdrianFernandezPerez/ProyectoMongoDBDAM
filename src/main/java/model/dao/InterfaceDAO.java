package main.java.model.dao;

import com.mongodb.client.MongoDatabase;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {
    void create(T t, MongoDatabase db) throws SQLException;
    List<T> findAll(MongoDatabase db);
    T find(MongoDatabase db, int id);
    void update(MongoDatabase db, T t);
    void delete(MongoDatabase db, int id);
}
