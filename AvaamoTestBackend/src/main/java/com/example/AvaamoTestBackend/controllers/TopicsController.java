package com.example.AvaamoTestBackend.controllers;

import com.example.AvaamoTestBackend.models.avaamoTestBackend.Topics;
import com.example.AvaamoTestBackend.models.avaamoTestBackend.dto.TopicsDto;
import com.example.AvaamoTestBackend.services.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/topics")
public class TopicsController {

    @Autowired
    TopicsService topicsService;

    @GetMapping(value = "/all-subjects")
    public List<Object> getAllSubjects() {
        return topicsService.getAllSubjects();
    }

    @GetMapping
    public Page<Topics> index(TopicsDto topicsDto,
                              @SortDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return topicsService.index(topicsDto, pageable);
    }

    @GetMapping(value = "/{id}")
    public Topics show(@PathVariable Long id) {
        return topicsService.show(id);
    }

    @PostMapping
    public Topics create(@RequestBody  TopicsDto topicsDto) throws Exception {
        return topicsService.create(topicsDto);
    }

    @PostMapping(value = "/{id}")
    public Topics update(@PathVariable Long id ,@RequestBody TopicsDto topicsDto) throws Exception {
        return topicsService.update(id, topicsDto);
    }
}
