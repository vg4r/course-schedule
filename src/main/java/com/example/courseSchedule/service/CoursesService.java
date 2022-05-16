package com.example.courseSchedule.service;

import com.example.courseSchedule.dao.CoursesDao;
import com.example.courseSchedule.api.dto.CourseDto;
import com.example.courseSchedule.dao.entity.CourseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CoursesService {
    private final CoursesDao coursesDao;
    private final MapperService<CourseEntity, CourseDto> courseEntityMapper;
    private final MapperService<CourseDto, CourseEntity> courseDtoMapper;


    public CoursesService(CoursesDao coursesDao,
                          MapperService<CourseEntity, CourseDto> courseEntityMapper,
                          MapperService<CourseDto, CourseEntity> courseDtoMapper) {
        this.coursesDao = coursesDao;
        this.courseEntityMapper = courseEntityMapper;
        this.courseDtoMapper = courseDtoMapper;
    }

    public List<CourseDto> getAll() {
        return coursesDao.getAll().stream().map(courseEntityMapper::map).collect(Collectors.toList());
    }

    public CourseDto get(Long id) {
        return courseEntityMapper.map(coursesDao.get(id));
    }

    public void create(CourseDto courseDto) {
        coursesDao.create(courseDtoMapper.map(courseDto));
    }

    public void remove(Long id) {
        coursesDao.remove(id);
    }
}
