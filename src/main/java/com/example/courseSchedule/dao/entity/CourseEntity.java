package com.example.courseSchedule.dao.entity;

public class CourseEntity {
    private Long id;
    private String name;
    private Long departmentId;
    private Integer credits;

    public CourseEntity(){

    }

    public CourseEntity(Long id, String name, Long departmentId, Integer credits) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public CourseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public CourseEntity setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public Integer getCredits() {
        return credits;
    }

    public CourseEntity setCredits(Integer credits) {
        this.credits = credits;
        return this;
    }
}
