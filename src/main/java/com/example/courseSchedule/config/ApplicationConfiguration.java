package com.example.courseSchedule.config;

import com.example.courseSchedule.api.dto.*;
import com.example.courseSchedule.dao.*;
import com.example.courseSchedule.dao.entity.CourseEntity;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import com.example.courseSchedule.dao.entity.ProfessorEntity;
import com.example.courseSchedule.dao.entity.ScheduleEntity;
import com.example.courseSchedule.dao.jdbc.*;
import com.example.courseSchedule.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public DepartmentsDao departmentsDao(JdbcTemplate jdbcTemplate){
        return new JDBCDepartmentsDao(jdbcTemplate);
    }

    @Bean
    public DepartmentsService departmentsService(DepartmentsDao departmentsDao,
                                             MapperService<DepartmentEntity, DepartmentDto> departmentEntityMapper,
                                             MapperService<DepartmentDto, DepartmentEntity> departmentDtoMapper){
        return new DepartmentsService(departmentsDao, departmentEntityMapper, departmentDtoMapper);
    }

    @Bean
    public ProfessorsDao professorsDao(JdbcTemplate jdbcTemplate){
        return new JDBCProfessorsDao(jdbcTemplate);
    }

    @Bean
    public ProfessorsService professorsService(ProfessorsDao professorsDao,
                                               MapperService<ProfessorEntity, ProfessorDto> departmentEntityMapper,
                                               MapperService<ProfessorDto, ProfessorEntity> departmentDtoMapper){
        return new ProfessorsService(professorsDao, departmentEntityMapper, departmentDtoMapper);
    }

    @Bean
    public CoursesDao coursesDao(JdbcTemplate jdbcTemplate){
        return new JDBCCourseDao(jdbcTemplate);
    }

    @Bean
    public CoursesService coursesService(CoursesDao coursesDao,
                                         MapperService<CourseEntity, CourseDto> courseEntityMapper,
                                         MapperService<CourseDto, CourseEntity> courseDtoMapper){
        return new CoursesService(coursesDao, courseEntityMapper, courseDtoMapper);
    }

    @Bean
    public ScheduleDao scheduleDao(JdbcTemplate jdbcTemplate){
        return new JDBCSchedulesDao(jdbcTemplate);
    }


    @Bean
    public ScheduleService scheduleService(ScheduleDao scheduleDao,
                                           MapperService<ScheduleEntity, ScheduleDto> scheduleEntityMapper,
                                           MapperService<ScheduleDto, ScheduleEntity> scheduleDtoMapper){
        return new ScheduleService(scheduleDao, scheduleEntityMapper, scheduleDtoMapper);
    }

    @Bean
    public SearchDao searchDao(JdbcTemplate jdbcTemplate){
        return new JDBCSearchDao(jdbcTemplate);
    }

    @Bean
    public SearchService searchService(SearchDao searchDao, MapperService<ProfessorEntity, SearchDto> professorEntitySearchMapper){
        return new SearchService(searchDao, professorEntitySearchMapper);
    }

}
