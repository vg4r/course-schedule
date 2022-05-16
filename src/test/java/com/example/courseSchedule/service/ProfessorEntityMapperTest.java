package com.example.courseSchedule.service;

import com.example.courseSchedule.api.dto.ProfessorDto;
import com.example.courseSchedule.config.MapperConfiguration;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import com.example.courseSchedule.dao.entity.ProfessorEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ProfessorEntityMapperTest {

    private static final ProfessorEntity TARGET = new ProfessorEntity().setId(1L).setName("Test Name")
            .setDepartment(new DepartmentEntity().setId(1L));
    private static final ProfessorDto EXPECTED = new ProfessorDto(TARGET.getId(), TARGET.getName(), TARGET.getDepartment().getId());

    private MapperService<ProfessorEntity, ProfessorDto> professorEntityMapper =
            new MapperConfiguration().professorEntityMapper();

    @Test
    void testMap() {
        //when
        ProfessorDto result = professorEntityMapper.map(TARGET);
        //then
        assertThat(result.getId()).isEqualTo(EXPECTED.getId());
        assertThat(result.getName()).isEqualTo(EXPECTED.getName());
    }
}