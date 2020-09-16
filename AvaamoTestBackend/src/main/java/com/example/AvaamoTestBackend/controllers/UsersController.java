package com.example.AvaamoTestBackend.controllers;

import com.example.AvaamoTestBackend.models.avaamoTestBackend.Users;
import com.example.AvaamoTestBackend.models.avaamoTestBackend.dto.UsersDto;
import com.example.AvaamoTestBackend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping
    public Users create(@RequestBody UsersDto usersDto) throws Exception{
        return usersService.create(usersDto);
    }

    @GetMapping
    public Users show(UsersDto usersDto) throws Exception {
        return usersService.show(usersDto);
    }
}
