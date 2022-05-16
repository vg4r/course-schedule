package com.example.courseSchedule.service;

import com.example.courseSchedule.dao.ProfessorsDao;
import com.example.courseSchedule.api.dto.ProfessorDto;
import com.example.courseSchedule.dao.entity.ProfessorEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProfessorsService {
    private final ProfessorsDao professorsDao;
    private final MapperService<ProfessorEntity, ProfessorDto> professorEntityMapper;
    private final MapperService<ProfessorDto, ProfessorEntity> professorDtoMapper;


    public ProfessorsService(ProfessorsDao professorsDao,
                             MapperService<ProfessorEntity, ProfessorDto> departmentEntityMapper,
                             MapperService<ProfessorDto, ProfessorEntity> departmentDtoMapper) {
        this.professorsDao = professorsDao;
        this.professorEntityMapper = departmentEntityMapper;
        this.professorDtoMapper = departmentDtoMapper;
    }

    public List<ProfessorDto> getAll() {
        return professorsDao.getAll().stream().map(professorEntityMapper::map).collect(Collectors.toList());
    }

    public ProfessorDto get(Long id) {
        return professorEntityMapper.map(professorsDao.get(id));
    }

    public void create(ProfessorDto professorDto) {
        professorsDao.create(professorDtoMapper.map(professorDto));
    }

    public void remove(Long id) {
        professorsDao.remove(id);
    }
}
