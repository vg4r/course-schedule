package com.example.courseSchedule.dao.entity;

public class ScheduleEntity {
    private Long professorId;
    private Long courseId;
    private Integer year;
    private Integer semester;

    public ScheduleEntity(){

    }

    public ScheduleEntity(Long professorId, Long courseId, Integer year, Integer semester) {
        this.professorId = professorId;
        this.courseId = courseId;
        this.year = year;
        this.semester = semester;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public ScheduleEntity setProfessorId(Long professorId) {
        this.professorId = professorId;
        return this;
    }

    public Long getCourseId() {
        return courseId;
    }

    public ScheduleEntity setCourseId(Long courseId) {
        this.courseId = courseId;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public ScheduleEntity setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getSemester() {
        return semester;
    }

    public ScheduleEntity setSemester(Integer semester) {
        this.semester = semester;
        return this;
    }
}
