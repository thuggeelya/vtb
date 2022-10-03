package com.example.thuggeelya.services;

import com.example.thuggeelya.data.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestService {

    private final GoodyRepository goodyRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public RestService(GoodyRepository goodyRepository, ActivityRepository activityRepository) {
        this.goodyRepository = goodyRepository;
        this.activityRepository = activityRepository;
    }

    public Page<Goody> getPageOfGoodies(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return goodyRepository.findAll(nextPage);
    }

    public Page<Activity> getPageOfActivities(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return activityRepository.findAll(nextPage);
    }

    public Page<Activity> getPageOfFurtherActivities(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return activityRepository.findAllByActivityStatusId(ActivityStatusEnum.FURTHER.getId(), nextPage);
    }

    public Page<Activity> getPageOfPassedActivities(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return activityRepository.findAllByActivityStatusId(ActivityStatusEnum.PASSED.getId(), nextPage);
    }

    public Page<Activity> getPageOfCurrentActivities(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return activityRepository.findAllByActivityStatusId(ActivityStatusEnum.CURRENT.getId(), nextPage);
    }

    public Page<Activity> getPageOfSearchResultActivities(String searchWord, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return activityRepository.findByNameContaining(searchWord, nextPage);
    }

    public List<User> getActivityParticipantsById(@NotNull Integer id) {
        return activityRepository.findById(id).orElseThrow().getUsers();
    }
}
