package com.example.courseSchedule.api;

import com.example.courseSchedule.api.dto.ScheduleDto;
import com.example.courseSchedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<ScheduleDto> getAll(){
        return scheduleService.getAll();
    }

    @GetMapping("/professors/{id}")
    public List<ScheduleDto> getByProfessorId(@PathVariable Long id){
        return scheduleService.getByProfessorId(id);
    }

    @GetMapping("/courses/{id}")
    public List<ScheduleDto> getByCourseId(@PathVariable Long id){
        return scheduleService.getByCourseId(id);
    }

    @PostMapping
    public void create(@RequestBody ScheduleDto departmentDto){
        scheduleService.create(departmentDto);
    }

    @DeleteMapping("/professors/{professorId}/courses/{courseId}")
    public void remove(@PathVariable Long professorId, @PathVariable Long courseId){
        scheduleService.remove(professorId, courseId);
    }
}
