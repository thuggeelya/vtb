package com.example.thuggeelya.services;

import com.example.thuggeelya.data.UserlevelRepository;
import org.springframework.stereotype.Service;

@Service
public class LevelExpService {

    private final UserlevelRepository userlevelRepository;

    public LevelExpService(UserlevelRepository userlevelRepository) {
        this.userlevelRepository = userlevelRepository;
    }


}
