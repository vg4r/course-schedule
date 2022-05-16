package com.example.courseSchedule.service;

import com.example.courseSchedule.dao.ScheduleDao;
import com.example.courseSchedule.api.dto.ScheduleDto;
import com.example.courseSchedule.dao.entity.ScheduleEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ScheduleService {
    private final ScheduleDao scheduleDao;
    private final MapperService<ScheduleEntity, ScheduleDto> scheduleEntityMapper;
    private final MapperService<ScheduleDto, ScheduleEntity> scheduleDtoMapper;


    public ScheduleService(ScheduleDao scheduleDao,
                           MapperService<ScheduleEntity, ScheduleDto> scheduleEntityMapper,
                           MapperService<ScheduleDto, ScheduleEntity> scheduleDtoMapper) {
        this.scheduleDao = scheduleDao;
        this.scheduleEntityMapper = scheduleEntityMapper;
        this.scheduleDtoMapper = scheduleDtoMapper;
    }

    public List<ScheduleDto> getAll() {
        return scheduleDao.getAll().stream().map(scheduleEntityMapper::map).collect(Collectors.toList());
    }

    public List<ScheduleDto> getByProfessorId(Long id) {
        return scheduleDao.getByProfessorId(id).stream().map(scheduleEntityMapper::map).collect(Collectors.toList());
    }

    public List<ScheduleDto> getByCourseId(Long id) {
        return scheduleDao.getByCourseId(id).stream().map(scheduleEntityMapper::map).collect(Collectors.toList());
    }

    public void create(ScheduleDto professorDto) {
        scheduleDao.create(scheduleDtoMapper.map(professorDto));
    }

    public void remove(Long professorId, Long courseId) {
        scheduleDao.remove(professorId, courseId);
    }
}
