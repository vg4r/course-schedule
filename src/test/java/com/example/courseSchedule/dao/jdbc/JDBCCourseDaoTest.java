package com.example.courseSchedule.dao.jdbc;

import com.example.courseSchedule.dao.CoursesDao;
import com.example.courseSchedule.dao.entity.CourseEntity;
import com.example.courseSchedule.exception.DataNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JDBCCourseDaoTest {

    private static CourseEntity COURSE_ENTITY = new CourseEntity().setId(1L).setName("Test course");

    private final JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    private final CoursesDao coursesDao = new JDBCCourseDao(jdbcTemplate);


    @Test
    void getAllReturnsNonEmptyResultWhenResultSetHasValue() {
        // given
        List<CourseEntity> courseEntities = List.of(COURSE_ENTITY);
        // when
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(courseEntities);
        //then
        assertThat(coursesDao.getAll()).containsAll(courseEntities);

    }

    @Test
    void getAllReturnsEmptyResultWhenResultSetDoesNotHaveValue() {
        // given
        // when
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of());
        //then
        assertThat(coursesDao.getAll()).isEmpty();

    }

    @Test
    void getReturnsResultWhenResultSetHasValue() {
        // given
        // when
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(COURSE_ENTITY.getId()))).thenReturn(COURSE_ENTITY);
        //then
        assertThat(coursesDao.get(COURSE_ENTITY.getId())).isEqualTo(COURSE_ENTITY);
    }

    @Test
    void getThrowsDataNotFoundExceptionWhenResultSetDoesNotHaveValue() {
        // given
        // when
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(COURSE_ENTITY.getId()))).thenThrow(EmptyResultDataAccessException.class);
        //then
        assertThatExceptionOfType(DataNotFoundException.class).isThrownBy(() -> coursesDao.get(COURSE_ENTITY.getId()));
    }

    @Test
    void remove() {
        when(jdbcTemplate.update(anyString(), eq(COURSE_ENTITY.getId()))).thenReturn(1);
        assertDoesNotThrow(() -> coursesDao.remove(COURSE_ENTITY.getId()));
    }

    @Test
    void create() {
        when(jdbcTemplate.update(anyString(), eq(COURSE_ENTITY.getName()), eq(COURSE_ENTITY.getDepartmentId()), eq(COURSE_ENTITY.getCredits())))
                .thenReturn(1);
        assertDoesNotThrow(() -> coursesDao.create(COURSE_ENTITY));
    }
}