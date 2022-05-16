package com.example.courseSchedule.dao.jdbc;

import com.example.courseSchedule.dao.Dao;
import com.example.courseSchedule.exception.DataNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class JDBCBaseDao <T> implements Dao<T> {

    private final JdbcTemplate jdbcTemplate;
    private final String selectQuery;
    private final String deleteQuery;
    private final RowMapper<T> rowMapper;

    public JDBCBaseDao(JdbcTemplate jdbcTemplate, String selectQuery, String deleteQuery, RowMapper<T> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.selectQuery = selectQuery;
        this.deleteQuery = deleteQuery;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<T> getAll() {
        return jdbcTemplate.query(selectQuery, rowMapper);
    }

    @Override
    public T get(Long id) {
        try {
            return jdbcTemplate.queryForObject(selectQuery + " WHERE id = ?", rowMapper, id);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new DataNotFoundException();
        }
    }

    @Override
    public void remove(Long id) {
        jdbcTemplate.update(deleteQuery, id);
    }

}
