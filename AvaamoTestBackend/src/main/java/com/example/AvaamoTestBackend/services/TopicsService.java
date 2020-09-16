package com.example.AvaamoTestBackend.services;

import com.example.AvaamoTestBackend.models.avaamoTestBackend.TopicCommentRelations;
import com.example.AvaamoTestBackend.models.avaamoTestBackend.Topics;
import com.example.AvaamoTestBackend.models.avaamoTestBackend.Users;
import com.example.AvaamoTestBackend.models.avaamoTestBackend.dto.TopicsDto;
import com.example.AvaamoTestBackend.repositories.avaamoTestBackend.TopicCommentRelationsRepository;
import com.example.AvaamoTestBackend.repositories.avaamoTestBackend.TopicsRepository;
import com.example.AvaamoTestBackend.repositories.avaamoTestBackend.UsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicsService {

    @Autowired
    TopicsRepository topicsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TopicCommentRelationsRepository topicCommentRelationsRepository;


    public List<Object> getAllSubjects() {
        return topicsRepository.getAllSubjects();
    }

    public Page<Topics> index(TopicsDto topicsDto, Pageable pageable) {
        if (topicsDto.getSubject() != null) {
            return topicsRepository.findBySubjectIsLike(topicsDto.getSubject(), pageable);
        }
        List<Topics.Type> types = new ArrayList<>();
        types.add(Topics.Type.COMMENTS);
        return topicsRepository.findAllByTypeIsNotIn(types, pageable);
    }

    public Topics show(Long id) {
        Optional<Topics> optionalTopics = topicsRepository.findById(id);
        return optionalTopics.get();
    }

    public Topics create(TopicsDto topicsDto) throws Exception {
        Topics topics = new Topics();
        copyNonNullProperties(topicsDto, topics);
        if (topicsDto.getCreatorId() == null) {
            throw new Exception("Creator cannot be null");
        }
        Optional<Users> optionalUsers = usersRepository.findById(topicsDto.getCreatorId().longValue());
        if (!optionalUsers.isPresent()) {
            throw new Exception("User not present");
        }
        topics.setUsers(optionalUsers.get());
        if (topicsDto.getType().equals(Topics.Type.COMMENTS)) {
            if (topicsDto.getTopicIdForComment() == null)
                throw new Exception("Comment Should have topic id");
            Optional<Topics> topicsForComment = topicsRepository.findById(topicsDto.getTopicIdForComment());
            if (!topicsForComment.isPresent()) {
                throw new Exception("Topic is not present for the comment");
            }
        }
        topicsRepository.save(topics);
        if (topicsDto.getType().equals(Topics.Type.COMMENTS)) {
            TopicCommentRelations topicCommentRelations = new TopicCommentRelations();
            topicCommentRelations.setCommentId(topics.getId());
            topicCommentRelations.setTopicId(topicsDto.getTopicIdForComment());
            topicCommentRelationsRepository.save(topicCommentRelations);
        }
        return topics;
    }

    public Topics update(Long id, TopicsDto topicsDto) throws Exception {
        Optional<Topics> optionalTopics = topicsRepository.findById(id);
        if (!optionalTopics.isPresent()) {
            throw new Exception("Topic not found");
        }
        Topics topics = optionalTopics.get();
        copyNonNullProperties(topicsDto, topics);
        topicsRepository.save(topics);
        return topics;
    }

    private static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
