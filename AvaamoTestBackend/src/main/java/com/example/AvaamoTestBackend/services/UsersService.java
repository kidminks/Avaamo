package com.example.AvaamoTestBackend.services;

import com.example.AvaamoTestBackend.models.avaamoTestBackend.Users;
import com.example.AvaamoTestBackend.models.avaamoTestBackend.dto.UsersDto;
import com.example.AvaamoTestBackend.repositories.avaamoTestBackend.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public Users show(UsersDto usersDto) throws Exception {
        Optional<Users> optionalUsers = usersRepository.findFirstByNameIsLikeAndPassword(usersDto.getName(), usersDto.getPassword());
        if (!optionalUsers.isPresent()) {
            throw new Exception("User not present");
        }
        return optionalUsers.get();
    }

    public Users create(UsersDto usersDto) throws Exception {
        Optional<Users> optionalUsers = usersRepository.findFirstByNameIsLike(usersDto.getName());
        if (optionalUsers.isPresent()) {
            throw new Exception("User is already present");
        }
        Users users = new Users();
        users.setName(usersDto.getName());
        users.setPassword(usersDto.getPassword());
        usersRepository.save(users);
        return  users;
    }
}
