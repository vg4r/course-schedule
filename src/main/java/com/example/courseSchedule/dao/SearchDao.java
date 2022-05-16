package com.example.courseSchedule.dao;

import com.example.courseSchedule.dao.entity.ProfessorEntity;

import java.util.List;

public interface SearchDao {
    List<ProfessorEntity> search();
}
