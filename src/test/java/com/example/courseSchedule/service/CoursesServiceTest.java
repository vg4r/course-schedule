package com.example.courseSchedule.service;

import com.example.courseSchedule.api.dto.CourseDto;
import com.example.courseSchedule.dao.CoursesDao;
import com.example.courseSchedule.dao.entity.CourseEntity;
import com.example.courseSchedule.exception.DataNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

class CoursesServiceTest {

    private static CourseEntity COURSE_ENTITY = new CourseEntity().setId(1L).setName("Test course").setDepartmentId(1L).setCredits(5);
    private static CourseDto COURSE_DTO =
            new CourseDto(COURSE_ENTITY.getId(), COURSE_ENTITY.getName(), COURSE_ENTITY.getDepartmentId(), COURSE_ENTITY.getCredits());

    private CoursesDao coursesDao = mock(CoursesDao.class);
    private MapperService<CourseEntity, CourseDto> courseEntityMapper = mock(MapperService.class);
    private MapperService<CourseDto, CourseEntity> courseDtoMapper = mock(MapperService.class);

    private CoursesService coursesService = new CoursesService(coursesDao, courseEntityMapper, courseDtoMapper);

    @Test
    void getAllReturnsMappedResultWhenDaoReturnsNonEmptyList() {
        List<CourseEntity> courseEntities = List.of(COURSE_ENTITY);
        when(coursesDao.getAll()).thenReturn(courseEntities);
        when(courseEntityMapper.map(COURSE_ENTITY)).thenReturn(COURSE_DTO);
        assertThat(coursesService.getAll()).containsAll(List.of(COURSE_DTO));
    }

    @Test
    void getAllReturnsEmptyListWhenDaoReturnsEmptyList() {
        when(coursesDao.getAll()).thenReturn(List.of());
        assertThat(coursesService.getAll()).isEmpty();
    }

    @Test
    void getReturnsMappedResultWhenDaoReturnsSomeValue() {
        when(coursesDao.get(COURSE_ENTITY.getId())).thenReturn(COURSE_ENTITY);
        when(courseEntityMapper.map(COURSE_ENTITY)).thenReturn(COURSE_DTO);
        assertThat(coursesService.get(COURSE_ENTITY.getId())).isEqualTo(COURSE_DTO);
    }

    @Test
    void getThrowsDataNotFoundExceptionWhenResultSetDoesNotHaveValue() {
        when(coursesDao.get(COURSE_ENTITY.getId())).thenThrow(DataNotFoundException.class);
        when(courseEntityMapper.map(COURSE_ENTITY)).thenReturn(COURSE_DTO);
        assertThatExceptionOfType(DataNotFoundException.class).isThrownBy(() -> coursesService.get(COURSE_ENTITY.getId()));
    }


    @Test
    void create() {
        when(courseDtoMapper.map(COURSE_DTO)).thenReturn(COURSE_ENTITY);
        doNothing().when(coursesDao).create(COURSE_ENTITY);
        assertDoesNotThrow(() -> coursesService.create(COURSE_DTO));
    }

    @Test
    void remove() {
        doNothing().when(coursesDao).remove(1L);
        assertDoesNotThrow(() -> coursesDao.remove(COURSE_ENTITY.getId()));
    }
}