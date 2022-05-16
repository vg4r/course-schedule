package com.example.courseSchedule.dao;

import com.example.courseSchedule.dao.entity.ScheduleEntity;

import java.util.List;

public interface ScheduleDao {
    List<ScheduleEntity> getAll();
    List<ScheduleEntity> getByProfessorId(Long id);
    List<ScheduleEntity> getByCourseId(Long id);
    void create(ScheduleEntity scheduleEntity);
    void remove(Long professorId, Long courseId);
}
