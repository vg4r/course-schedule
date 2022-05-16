package com.example.courseSchedule.dao.jdbc;

import com.example.courseSchedule.dao.ProfessorsDao;
import com.example.courseSchedule.dao.ScheduleDao;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import com.example.courseSchedule.dao.entity.ProfessorEntity;
import com.example.courseSchedule.dao.entity.ScheduleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JDBCSchedulesDaoTest {

    private static ScheduleEntity SCHEDULE_ENTITY = new ScheduleEntity().setProfessorId(1L).setCourseId(1L).setSemester(1).setYear(2022);

    private final JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    private final ScheduleDao scheduleDao = new JDBCSchedulesDao(jdbcTemplate);


    @Test
    void getAllReturnsNonEmptyResultWhenResultSetHasValue() {
        // given
        List<ScheduleEntity> professorEntities = List.of(SCHEDULE_ENTITY);
        // when
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(professorEntities);
        //then
        assertThat(scheduleDao.getAll()).containsAll(professorEntities);

    }

    @Test
    void getAllReturnsEmptyResultWhenResultSetDoesNotHaveValue() {
        // given
        // when
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of());
        //then
        assertThat(scheduleDao.getAll()).isEmpty();
    }

    @Test
    void remove() {
        when(jdbcTemplate.update(anyString(), eq(SCHEDULE_ENTITY.getProfessorId()), eq(SCHEDULE_ENTITY.getCourseId()))).thenReturn(1);
        assertDoesNotThrow(() -> scheduleDao.remove(SCHEDULE_ENTITY.getProfessorId(), SCHEDULE_ENTITY.getCourseId()));
    }

    @Test
    void create() {
        when(jdbcTemplate.update(anyString(),
                eq(SCHEDULE_ENTITY.getProfessorId()),
                eq(SCHEDULE_ENTITY.getCourseId()),
                eq(SCHEDULE_ENTITY.getYear()),
                eq(SCHEDULE_ENTITY.getSemester()))).thenReturn(1);
        assertDoesNotThrow(() -> scheduleDao.create(SCHEDULE_ENTITY));
    }

}