package com.example.courseSchedule.service;

import com.example.courseSchedule.api.dto.DepartmentDto;
import com.example.courseSchedule.config.MapperConfiguration;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class DepartmentDtoMapperTest {

    private static final DepartmentDto TARGET =new DepartmentDto(1L, "Test Department");
    private static final DepartmentEntity EXPECTED = new DepartmentEntity(TARGET.getId(), TARGET.getName());

    private MapperService<DepartmentDto ,DepartmentEntity > departmentDtoMapper = new MapperConfiguration().departmentDtoMapper();

    @Test
    void testMap() {
        //when
        DepartmentEntity result = departmentDtoMapper.map(TARGET);
        //then
        assertThat(result.getId()).isEqualTo(EXPECTED.getId());
        assertThat(result.getName()).isEqualTo(EXPECTED.getName());
    }
}