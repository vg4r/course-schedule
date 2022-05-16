package com.example.courseSchedule.service;

import com.example.courseSchedule.api.dto.ProfessorDto;
import com.example.courseSchedule.config.MapperConfiguration;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import com.example.courseSchedule.dao.entity.ProfessorEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ProfessorDtoMapperTest {

    private static final ProfessorDto TARGET =new ProfessorDto(1L, "Test Name", 1L);
    private static final ProfessorEntity EXPECTED = new ProfessorEntity(TARGET.getId(), TARGET.getName(), new DepartmentEntity().setId(1L));

    private MapperService<ProfessorDto ,ProfessorEntity > professorDtoMapper = new MapperConfiguration().professorDtoMapper();

    @Test
    void testMap() {
        //when
        ProfessorEntity result = professorDtoMapper.map(TARGET);
        //then
        assertThat(result.getId()).isEqualTo(EXPECTED.getId());
        assertThat(result.getName()).isEqualTo(EXPECTED.getName());
    }
}