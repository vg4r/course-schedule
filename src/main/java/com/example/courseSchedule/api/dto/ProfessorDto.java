package com.example.courseSchedule.api.dto;

public class ProfessorDto {
    private Long id;
    private String name;
    private Long departmentId;

    public ProfessorDto(Long id, String name, Long departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
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

    public void setDepartment(Long departmentId) {
        this.departmentId = departmentId;
    }
}
