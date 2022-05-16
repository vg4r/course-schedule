package com.example.courseSchedule.service;

import com.example.courseSchedule.dao.DepartmentsDao;
import com.example.courseSchedule.api.dto.DepartmentDto;
import com.example.courseSchedule.dao.entity.DepartmentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentsService {
    private final DepartmentsDao departmentsDao;
    private final MapperService<DepartmentEntity, DepartmentDto> departmentEntityMapper;
    private final MapperService<DepartmentDto, DepartmentEntity> departmentDtoMapper;


    public DepartmentsService(DepartmentsDao departmentsDao,
                              MapperService<DepartmentEntity, DepartmentDto> departmentEntityMapper,
                              MapperService<DepartmentDto, DepartmentEntity> departmentDtoMapper) {
        this.departmentsDao = departmentsDao;
        this.departmentEntityMapper = departmentEntityMapper;
        this.departmentDtoMapper = departmentDtoMapper;
    }

    public List<DepartmentDto> getAll() {
        return departmentsDao.getAll().stream().map(departmentEntityMapper::map).collect(Collectors.toList());
    }

    public DepartmentDto get(Long id) {
        return departmentEntityMapper.map(departmentsDao.get(id));
    }

    public void create(DepartmentDto departmentDto) {
        departmentsDao.create(departmentDtoMapper.map(departmentDto));
    }

    public void remove(Long id) {
        departmentsDao.remove(id);
    }
}
