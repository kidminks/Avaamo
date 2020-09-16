package com.example.AvaamoTestBackend.repositories.avaamoTestBackend;

import com.example.AvaamoTestBackend.models.avaamoTestBackend.Topics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicsRepository extends PagingAndSortingRepository<Topics, Long>, JpaRepository<Topics, Long> {

    Page<Topics> findAllByTypeIsNotIn(List<Topics.Type> types, Pageable pageable);

    Page<Topics> findBySubjectIsLike(String subject, Pageable pageable);

    @Query(value = "select id, subject from topics", nativeQuery = true)
    List<Object> getAllSubjects();
}
