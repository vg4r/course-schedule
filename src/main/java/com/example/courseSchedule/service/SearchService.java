package com.example.courseSchedule.service;

import com.example.courseSchedule.api.dto.SearchDto;
import com.example.courseSchedule.dao.SearchDao;
import com.example.courseSchedule.dao.entity.ProfessorEntity;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
    private final SearchDao searchDao;
    private final MapperService<ProfessorEntity, SearchDto> professorEntitySearchMapper;

    public SearchService(SearchDao searchDao,
                         MapperService<ProfessorEntity, SearchDto> professorEntitySearchMapper) {
        this.searchDao = searchDao;
        this.professorEntitySearchMapper = professorEntitySearchMapper;
    }

    public List<SearchDto> search() {
        return searchDao.search().stream().map(professorEntitySearchMapper::map).collect(Collectors.toList());
    }
}
