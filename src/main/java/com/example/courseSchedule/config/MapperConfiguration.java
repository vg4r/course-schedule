package com.example.courseSchedule.config;

import com.example.courseSchedule.api.dto.*;
import com.example.courseSchedule.dao.entity.CourseEntity;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import com.example.courseSchedule.dao.entity.ProfessorEntity;
import com.example.courseSchedule.dao.entity.ScheduleEntity;
import com.example.courseSchedule.service.MapperService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

@Configuration
public class MapperConfiguration {

    @Bean
    public MapperService<DepartmentEntity, DepartmentDto> departmentEntityMapper() {
        return departmentEntity -> new DepartmentDto(departmentEntity.getId(), departmentEntity.getName());
    }

    @Bean
    public MapperService<DepartmentDto, DepartmentEntity> departmentDtoMapper() {
        return departmentDto -> new DepartmentEntity(departmentDto.getId(), departmentDto.getName());
    }


    @Bean
    public MapperService<ProfessorEntity, ProfessorDto> professorEntityMapper() {
        return professorEntity -> new ProfessorDto(professorEntity.getId(), professorEntity.getName(), professorEntity.getDepartment().getId());
    }

    @Bean
    public MapperService<ProfessorDto, ProfessorEntity> professorDtoMapper() {
        return professorDto -> new ProfessorEntity(professorDto.getId(), professorDto.getName(), new DepartmentEntity(professorDto.getDepartmentId(), null));
    }


    @Bean
    public MapperService<CourseEntity, CourseDto> courseEntityMapper() {
        return courseEntity -> new CourseDto(courseEntity.getId(), courseEntity.getName(), courseEntity.getDepartmentId(), courseEntity.getCredits());
    }

    @Bean
    public MapperService<CourseDto, CourseEntity> courseDtoMapper() {
        return courseDto -> new CourseEntity(courseDto.getId(), courseDto.getName(), courseDto.getDepartmentId(), courseDto.getCredits());
    }

    @Bean
    public MapperService<ScheduleEntity, ScheduleDto> scheduleEntityMapper() {
        return scheduleEntity -> new ScheduleDto(scheduleEntity.getProfessorId(), scheduleEntity.getCourseId(), scheduleEntity.getYear(), scheduleEntity.getSemester());
    }

    @Bean
    public MapperService<ScheduleDto, ScheduleEntity> scheduleDtoMapper() {
        return scheduleDto -> new ScheduleEntity(scheduleDto.getProfessorId(), scheduleDto.getCourseId(), scheduleDto.getYear(), scheduleDto.getSemester());
    }


    @Bean
    public MapperService<ProfessorEntity, SearchDto> professorEntitySearchMapper() {
        return professorEntity -> new SearchDto()
                .setName(professorEntity.getName())
                .setCourses(professorEntity.getDepartment().getCourses().stream().map(CourseEntity::getName).collect(Collectors.toList()));
    }

}
