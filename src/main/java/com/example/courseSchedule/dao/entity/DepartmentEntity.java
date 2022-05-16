package com.example.courseSchedule.dao.entity;

import java.util.List;

public class DepartmentEntity {
    private Long id;
    private String name;
    private List<CourseEntity> courses;

    public DepartmentEntity() {
    }

    public DepartmentEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public DepartmentEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DepartmentEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public DepartmentEntity setCourses(List<CourseEntity> courses) {
        this.courses = courses;
        return this;
    }
}
