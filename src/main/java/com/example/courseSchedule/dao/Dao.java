package com.example.courseSchedule.dao;

import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    T get(Long id);

    void remove(Long id);

}
