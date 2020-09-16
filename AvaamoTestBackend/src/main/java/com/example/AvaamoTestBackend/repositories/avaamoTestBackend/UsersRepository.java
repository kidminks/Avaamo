package com.example.AvaamoTestBackend.repositories.avaamoTestBackend;

import com.example.AvaamoTestBackend.models.avaamoTestBackend.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findFirstByNameIsLikeAndPassword(String name, String password);
    Optional<Users> findFirstByNameIsLike(String name);
}
