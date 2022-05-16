package com.example.courseSchedule.api.dto;

public class CourseDto {
    private Long id;
    private String name;
    private Long departmentId;
    private Integer credits;

    public CourseDto(Long id, String name, Long departmentId, Integer credits) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
