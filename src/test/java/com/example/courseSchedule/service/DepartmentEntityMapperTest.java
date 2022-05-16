package com.example.courseSchedule.service;

import com.example.courseSchedule.api.dto.DepartmentDto;
import com.example.courseSchedule.config.MapperConfiguration;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class DepartmentEntityMapperTest {

    private static final DepartmentEntity TARGET = new DepartmentEntity().setId(1L).setName("Test Department");
    private static final DepartmentDto EXPECTED = new DepartmentDto(TARGET.getId(), TARGET.getName());

    private MapperService<DepartmentEntity, DepartmentDto> departmentEntityMapper = new MapperConfiguration().departmentEntityMapper();

    @Test
    void testMap() {
        //when
        DepartmentDto result = departmentEntityMapper.map(TARGET);
        //then
        assertThat(result.getId()).isEqualTo(EXPECTED.getId());
        assertThat(result.getName()).isEqualTo(EXPECTED.getName());
    }
}