package com.example.courseSchedule.dao.entity;

public class ProfessorEntity {
    private Long id;
    private String name;
    private DepartmentEntity department;

    public ProfessorEntity(){

    }

    public ProfessorEntity(Long id, String name, DepartmentEntity department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public ProfessorEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProfessorEntity setName(String name) {
        this.name = name;
        return this;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public ProfessorEntity setDepartment(DepartmentEntity department) {
        this.department = department;
        return this;
    }
}
