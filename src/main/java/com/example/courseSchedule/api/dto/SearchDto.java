package com.example.courseSchedule.api.dto;

import java.util.List;

public class SearchDto {
    private String name;
    private List<String> courses;

    public String getName() {
        return name;
    }

    public SearchDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getCourses() {
        return courses;
    }

    public SearchDto setCourses(List<String> courses) {
        this.courses = courses;
        return this;
    }
}
