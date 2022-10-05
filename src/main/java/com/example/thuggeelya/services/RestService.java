package com.example.thuggeelya.services;

import com.example.thuggeelya.data.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RestService {

    private final GoodyRepository goodyRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public RestService(GoodyRepository goodyRepository, ActivityRepository activityRepository) {
        this.goodyRepository = goodyRepository;
        this.activityRepository = activityRepository;
    }

    public List<Goody> getGoodies() {
        return goodyRepository.findAll();
    }

    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    public List<Activity> getFurtherActivities() {
        return activityRepository.findAllByActivityStatusId(ActivityStatusEnum.FURTHER.getId());
    }

    public List<Activity> getPassedActivities() {
        return activityRepository.findAllByActivityStatusId(ActivityStatusEnum.PASSED.getId());
    }

    public List<Activity> getCurrentActivities() {
        return activityRepository.findAllByActivityStatusId(ActivityStatusEnum.CURRENT.getId());
    }

    public List<Activity> getSearchResultActivities(String searchWord) {
        return activityRepository.findAllByNameContaining(searchWord);
    }

    public List<User> getActivityParticipantsById(@NotNull Integer id) {
        return activityRepository.findById(id).orElseThrow(NoSuchElementException::new).getUsers();
    }
}
