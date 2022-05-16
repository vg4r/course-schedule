package com.example.courseSchedule.dao.jdbc;

import com.example.courseSchedule.dao.ProfessorsDao;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import com.example.courseSchedule.dao.entity.ProfessorEntity;
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

class JDBCProfessorsDaoTest {
    private static ProfessorEntity PROFESSOR_ENTITY = new ProfessorEntity().setId(1L).setName("Test name").setDepartment(new DepartmentEntity().setId(1L));

    private final JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    private final ProfessorsDao professorsDao = new JDBCProfessorsDao(jdbcTemplate);

    @Test
    void getAllReturnsNonEmptyResultWhenResultSetHasValue() {
        // given
        List<ProfessorEntity> professorEntities = List.of(PROFESSOR_ENTITY);
        // when
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(professorEntities);
        //then
        assertThat(professorsDao.getAll()).containsAll(professorEntities);

    }

    @Test
    void getAllReturnsEmptyResultWhenResultSetDoesNotHaveValue() {
        // given
        // when
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of());
        //then
        assertThat(professorsDao.getAll()).isEmpty();

    }

    @Test
    void getReturnsResultWhenResultSetHasValue() {
        // given
        // when
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(PROFESSOR_ENTITY.getId()))).thenReturn(PROFESSOR_ENTITY);
        //then
        assertThat(professorsDao.get(PROFESSOR_ENTITY.getId())).isEqualTo(PROFESSOR_ENTITY);
    }

    @Test
    void getThrowsDataNotFoundExceptionWhenResultSetDoesNotHaveValue() {
        // given
        // when
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(PROFESSOR_ENTITY.getId()))).thenThrow(EmptyResultDataAccessException.class);
        //then
        assertThatExceptionOfType(DataNotFoundException.class).isThrownBy(() -> professorsDao.get(PROFESSOR_ENTITY.getId()));
    }

    @Test
    void remove() {
        when(jdbcTemplate.update(anyString(), eq(PROFESSOR_ENTITY.getId()))).thenReturn(1);
        assertDoesNotThrow(() -> professorsDao.remove(PROFESSOR_ENTITY.getId()));
    }

    @Test
    void create() {
        when(jdbcTemplate.update(anyString(), eq(PROFESSOR_ENTITY.getName()), eq(PROFESSOR_ENTITY.getDepartment().getId()))).thenReturn(1);
        assertDoesNotThrow(() -> professorsDao.create(PROFESSOR_ENTITY));
    }
}