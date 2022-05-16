package com.example.courseSchedule.dao.jdbc;

import com.example.courseSchedule.dao.CoursesDao;
import com.example.courseSchedule.dao.DepartmentsDao;
import com.example.courseSchedule.dao.entity.CourseEntity;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import com.example.courseSchedule.exception.DataNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JDBCDepartmentsDaoTest {

    private static DepartmentEntity DEPARTMENT_ENTITY = new DepartmentEntity().setId(1L).setName("Test department");

    private final JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    private final DepartmentsDao departmentsDao = new JDBCDepartmentsDao(jdbcTemplate);

    @Test
    void getAllReturnsNonEmptyResultWhenResultSetHasValue() {
        // given
        List<DepartmentEntity> courseEntities = List.of(DEPARTMENT_ENTITY);
        // when
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(courseEntities);
        //then
        assertThat(departmentsDao.getAll()).containsAll(courseEntities);

    }

    @Test
    void getAllReturnsEmptyResultWhenResultSetDoesNotHaveValue() {
        // given
        // when
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of());
        //then
        assertThat(departmentsDao.getAll()).isEmpty();

    }

    @Test
    void getReturnsResultWhenResultSetHasValue() {
        // given
        // when
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(DEPARTMENT_ENTITY.getId()))).thenReturn(DEPARTMENT_ENTITY);
        //then
        assertThat(departmentsDao.get(DEPARTMENT_ENTITY.getId())).isEqualTo(DEPARTMENT_ENTITY);
    }

    @Test
    void getThrowsDataNotFoundExceptionWhenResultSetDoesNotHaveValue() {
        // given
        // when
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(DEPARTMENT_ENTITY.getId()))).thenThrow(EmptyResultDataAccessException.class);
        //then
        assertThatExceptionOfType(DataNotFoundException.class).isThrownBy(() -> departmentsDao.get(DEPARTMENT_ENTITY.getId()));
    }

    @Test
    void remove() {
        when(jdbcTemplate.update(anyString(), eq(DEPARTMENT_ENTITY.getId()))).thenReturn(1);
        assertDoesNotThrow(() -> departmentsDao.remove(DEPARTMENT_ENTITY.getId()));
    }

    @Test
    void create() {
        when(jdbcTemplate.update(anyString(), eq(DEPARTMENT_ENTITY.getName()))).thenReturn(1);
        assertDoesNotThrow(() -> departmentsDao.create(DEPARTMENT_ENTITY));
    }
}