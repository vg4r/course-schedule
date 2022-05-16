package com.example.courseSchedule.dao;

import com.example.courseSchedule.dao.entity.ProfessorEntity;

public interface ProfessorsDao extends Dao<ProfessorEntity>{
    void create(ProfessorEntity departmentEntity);
}
