package com.example.courseSchedule.api;

import com.example.courseSchedule.api.dto.CourseDto;
import com.example.courseSchedule.service.CoursesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService){
        this.coursesService = coursesService;
    }

    @GetMapping
    public List<CourseDto> getAll(){
        return coursesService.getAll();
    }

    @GetMapping("/{id}")
    public CourseDto get(@PathVariable Long id){
        return coursesService.get(id);
    }

    @PostMapping
    public void create(@RequestBody CourseDto courseDto){
        coursesService.create(courseDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        coursesService.remove(id);
    }
}
