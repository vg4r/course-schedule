package com.example.courseSchedule.api;


import com.example.courseSchedule.api.dto.DepartmentDto;
import com.example.courseSchedule.service.DepartmentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/departments")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService){
        this.departmentsService = departmentsService;
    }


    @GetMapping("/departments")
    public List<DepartmentDto> getAll(){
        return departmentsService.getAll();
    }

    @GetMapping("/departments/{id}")
    public DepartmentDto get(@PathVariable Long id){
        return departmentsService.get(id);
    }

    @PostMapping("/departments")
    public void create(@RequestBody DepartmentDto departmentDto){
        departmentsService.create(departmentDto);
    }

    @DeleteMapping("/departments/{id}")
    public void remove(@PathVariable Long id){
        departmentsService.remove(id);
    }
}
