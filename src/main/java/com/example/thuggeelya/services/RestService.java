package com.example.thuggeelya.services;

import com.example.thuggeelya.data.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RestService {

    private final GoodyRepository goodyRepository;
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    @Autowired
    public RestService(GoodyRepository goodyRepository, ActivityRepository activityRepository, UserRepository userRepository) {
        this.goodyRepository = goodyRepository;
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
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
        return new ArrayList<>(activityRepository.findById(id).orElseThrow(NoSuchElementException::new).getUsers());
    }

    public int updateUserBalance(Integer balance, Integer iduser) {
        return userRepository.updateUserBalance(balance, iduser);
    }

    public List<User> findByBalanceIs(Integer balance) {
        return userRepository.findByBalanceIs(balance);
    }

    public List<User> findByBalanceBetween(Integer balanceStart, Integer balanceEnd) {
        return userRepository.findByBalanceBetweenOrderByBalanceDesc(balanceStart, balanceEnd);
    }

    public Activity getActivity(Integer id) {
        return activityRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
