package com.example.courseSchedule.dao;

import com.example.courseSchedule.dao.entity.CourseEntity;

public interface CoursesDao extends Dao<CourseEntity>{
    void create(CourseEntity courseEntity);
}
