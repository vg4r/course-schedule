package com.example.courseSchedule.api;

import com.example.courseSchedule.api.dto.SearchDto;
import com.example.courseSchedule.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping
    public List<SearchDto> getAll(){
        return searchService.search();
    }
}
