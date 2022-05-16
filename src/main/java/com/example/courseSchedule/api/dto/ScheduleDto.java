package com.example.courseSchedule.api.dto;

public class ScheduleDto {
    private Long professorId;
    private Long courseId;
    private Integer year;
    private Integer semester;

    public ScheduleDto(Long professorId, Long courseId, Integer year, Integer semester) {
        this.professorId = professorId;
        this.courseId = courseId;
        this.year = year;
        this.semester = semester;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}
