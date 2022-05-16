package com.example.courseSchedule.dao;

import com.example.courseSchedule.dao.entity.DepartmentEntity;

public interface DepartmentsDao extends Dao<DepartmentEntity> {

    void create(DepartmentEntity departmentEntity);

}
