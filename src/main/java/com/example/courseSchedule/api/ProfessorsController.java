package com.example.courseSchedule.api;

import com.example.courseSchedule.api.dto.ProfessorDto;
import com.example.courseSchedule.service.ProfessorsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorsController {

    private final ProfessorsService professorsService;

    public ProfessorsController(ProfessorsService professorsService){
        this.professorsService = professorsService;
    }

    @GetMapping
    public List<ProfessorDto> getAll(){
        return professorsService.getAll();
    }

    @GetMapping("/{id}")
    public ProfessorDto get(@PathVariable Long id){
        return professorsService.get(id);
    }

    @PostMapping
    public void create(@RequestBody ProfessorDto departmentDto){
        professorsService.create(departmentDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        professorsService.remove(id);
    }
}
