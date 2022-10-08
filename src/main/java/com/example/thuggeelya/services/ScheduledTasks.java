package com.example.thuggeelya.services;

import com.example.thuggeelya.data.UserRepository;
import com.example.thuggeelya.data.UserlevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class ScheduledTasks {

    private final UserRepository userRepository;
    private final UserlevelRepository userlevelRepository;

    @Autowired
    public ScheduledTasks(UserRepository userRepository, UserlevelRepository userlevelRepository) {
        this.userRepository = userRepository;
        this.userlevelRepository = userlevelRepository;
    }

    @Scheduled(cron = "0 0 0 1 1/1 *")
    public void da() {
        System.out.println("top up user balances ..");
        // TODO: top up user balances
    }

    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.DAYS)
    public void levelUp() {
        Integer dailyExpUpper = 100;
        ExecutorService executorService = Executors.newCachedThreadPool();

    }
}