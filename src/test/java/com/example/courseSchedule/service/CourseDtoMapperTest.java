package com.example.courseSchedule.service;

import com.example.courseSchedule.api.dto.CourseDto;
import com.example.courseSchedule.config.MapperConfiguration;
import com.example.courseSchedule.dao.entity.CourseEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CourseDtoMapperTest {

    private static final CourseDto TARGET =new CourseDto(1L, "Test Course", 1L, 3);
    private static final CourseEntity EXPECTED = new CourseEntity(TARGET.getId(), TARGET.getName(), TARGET.getDepartmentId(), TARGET.getCredits());

    private MapperService<CourseDto, CourseEntity> courseDtoMapper = new MapperConfiguration().courseDtoMapper();

    @Test
    void testMap() {
        //when
        CourseEntity result = courseDtoMapper.map(TARGET);
        //then
        assertThat(result.getId()).isEqualTo(EXPECTED.getId());
        assertThat(result.getName()).isEqualTo(EXPECTED.getName());
    }
}